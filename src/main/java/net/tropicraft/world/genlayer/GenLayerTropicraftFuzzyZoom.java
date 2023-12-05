package net.tropicraft.world.genlayer;

public class GenLayerTropicraftFuzzyZoom extends GenLayerTropicraftZoom {

    public GenLayerTropicraftFuzzyZoom(final long seed, final GenLayerTropicraft parent) {
        super(seed, parent);
    }

    protected int selectModeOrRandom(final int b1, final int b2, final int b3, final int b4) {
        return this.selectRandom(new int[] { b1, b2, b3, b4 });
    }
}
