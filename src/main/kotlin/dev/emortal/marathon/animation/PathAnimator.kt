package dev.emortal.marathon.animation

import dev.emortal.immortal.game.Game
import net.minestom.server.coordinate.Point
import net.minestom.server.coordinate.Vec
import net.minestom.server.entity.Entity
import net.minestom.server.entity.EntityType
import net.minestom.server.entity.metadata.other.FallingBlockMeta
import net.minestom.server.instance.block.Block
import net.minestom.server.timer.Task
import world.cepi.kstom.Manager
import world.cepi.kstom.Manager.block
import world.cepi.kstom.util.asPos
import world.cepi.kstom.util.asVec
import world.cepi.particle.Particle
import world.cepi.particle.ParticleType
import world.cepi.particle.data.OffsetAndSpeed
import world.cepi.particle.extra.Dust
import world.cepi.particle.showParticle
import world.cepi.particle.util.Vectors
import java.time.Duration

class PathAnimator(game: Game) : BlockAnimator(game) {

    var lastSandEntity: Entity? = null

    private fun getLastPos(): Point? {
        if (lastSandEntity != null && lastSandEntity!!.aliveTicks < 2) return null
        return lastSandEntity?.position?.sub(0.5, 0.0, 0.5)
    }

    override fun setBlockAnimated(point: Point, block: Block, lastPoint: Point) {
        val timeToAnimate = 0.3

        val actualLastPoint = getLastPos() ?: lastPoint

        val fallingBlock = Entity(EntityType.FALLING_BLOCK)
        val fallingBlockMeta = fallingBlock.entityMeta as FallingBlockMeta

        fallingBlock.setNoGravity(true)
        fallingBlockMeta.block = block

        fallingBlock.velocity = point
            .sub(actualLastPoint)
            .asVec()
            .normalize()
            .mul((1 / timeToAnimate) * 1.15 * point.distance(actualLastPoint))
        fallingBlock.setInstance(game.instance, actualLastPoint.add(0.5, 0.0, 1.5))
        fallingBlock.scheduleNextTick {
            it.teleport(actualLastPoint.add(0.5, 0.0, 0.5).asPos())
        }

        lastSandEntity = fallingBlock

        game.showParticle(
            Particle.particle(
                type = ParticleType.DUST,
                count = 1,
                data = OffsetAndSpeed(0f, 0f, 0f, 0f),
                extraData = Dust(1f, 1f, 0f, 1f)
            ), Vectors(point.asVec().add(0.5, 0.5, 0.5), actualLastPoint.asVec().add(0.5, 0.5, 0.5), 0.35)
        )

        Manager.scheduler.buildTask {
            game.instance.setBlock(point, block)
            fallingBlock.remove()

            lastSandEntity = null
        }.delay(Duration.ofMillis((timeToAnimate * 1000L).toLong())).schedule()
    }
}