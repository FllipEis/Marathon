package dev.emortal.marathon.animation

import dev.emortal.immortal.game.Game
import dev.emortal.marathon.utils.breakBlock
import net.minestom.server.coordinate.Point
import net.minestom.server.instance.block.Block
import net.minestom.server.timer.Task
import java.util.concurrent.ConcurrentHashMap

abstract class BlockAnimator(val game: Game) {

    val tasks: MutableSet<Task> = ConcurrentHashMap.newKeySet()

    abstract fun setBlockAnimated(point: Point, block: Block, lastPoint: Point)

    open fun destroyBlockAnimated(point: Point) {
        //game.breakBlock(point, lastBlock)
        game.instance.setBlock(point, Block.AIR)
    }

}