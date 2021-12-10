package dev.emortal.marathon.animation

import dev.emortal.immortal.game.Game
import dev.emortal.marathon.utils.setBlock
import net.minestom.server.coordinate.Point
import net.minestom.server.instance.block.Block

class NoAnimator(game: Game) : BlockAnimator(game) {
    override fun setBlockAnimated(point: Point, block: Block, lastPoint: Point, lastBlock: Block) {
        game.setBlock(point, block)
    }

    override fun destroyBlockAnimated(point: Point, block: Block) {
        game.setBlock(point, Block.AIR)
    }
}