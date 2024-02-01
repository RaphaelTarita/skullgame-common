package com.rtarita.skull.common.state

import com.rtarita.skull.common.hash

public sealed class StateSignal(
    private val code: Byte,
    public val gameid: String
) {
    public companion object {
        private const val CODE_CLIENT_REQUEST_UPDATES: Byte = 0
        private const val CODE_CLIENT_STOP_UPDATES: Byte = 1
        private const val CODE_SERVER_ACK: Byte = 2
        private const val CODE_SERVER_GAME_START: Byte = 3
        private const val CODE_SERVER_GAME_UPDATE: Byte = 4
        private const val CODE_SERVER_GAME_ENDED: Byte = 5

        private fun unknownCode(code: Byte, domain: String? = null): Nothing =
            throw IllegalArgumentException("unknown ${if (domain != null) "$domain " else ""}code: $code")

        public fun deserialize(bytes: ByteArray): StateSignal {
            val gameid = bytes.decodeToString(1)
            return when (bytes.first()) {
                CODE_CLIENT_REQUEST_UPDATES -> Client.RequestUpdates(gameid)
                CODE_CLIENT_STOP_UPDATES -> Client.StopUpdates(gameid)
                CODE_SERVER_ACK -> Server.Ack
                CODE_SERVER_GAME_START -> Server.GameStart(gameid)
                CODE_SERVER_GAME_UPDATE -> Server.GameUpdate(gameid)
                CODE_SERVER_GAME_ENDED -> Server.GameEnded(gameid)
                else -> unknownCode(bytes.first())
            }
        }

        public fun deserializeClient(bytes: ByteArray): Client = deserialize(bytes) as? Client ?: unknownCode(bytes.first(), "client")

        public fun deserializeServer(bytes: ByteArray): Server = deserialize(bytes) as? Server ?: unknownCode(bytes.first(), "server")
    }

    public fun serialize(): ByteArray = byteArrayOf(code) + gameid.encodeToByteArray()

    public sealed class Client(code: Byte, gameid: String) : StateSignal(code, gameid) {
        public class RequestUpdates(gameid: String) : Client(CODE_CLIENT_REQUEST_UPDATES, gameid)
        public class StopUpdates(gameid: String) : Client(CODE_CLIENT_STOP_UPDATES, gameid)
    }

    public sealed class Server(code: Byte, gameid: String) : StateSignal(code, gameid) {
        public object Ack : Server(CODE_SERVER_ACK, "")
        public class GameStart(gameid: String) : Server(CODE_SERVER_GAME_START, gameid)
        public class GameUpdate(gameid: String) : Server(CODE_SERVER_GAME_UPDATE, gameid)
        public class GameEnded(gameid: String) : Server(CODE_SERVER_GAME_ENDED, gameid)
    }

    override fun equals(other: Any?): Boolean = if (other is StateSignal) code == other.code && gameid == other.gameid else false
    override fun hashCode(): Int = hash(code, gameid)
    override fun toString(): String = "$code#${this::class.simpleName}" + if (gameid.isNotEmpty()) "($gameid)" else ""
}
