package net.tropicraft.world.perlin;

public abstract class NoiseModule {

    public double frequency;
    public double amplitude;

    public NoiseModule() {
        this.frequency = 1.0;
        this.amplitude = 1.0;
    }

    public abstract double getNoise(final double p0);

    public abstract double getNoise(final double p0, final double p1);

    public abstract double getNoise(final double p0, final double p1, final double p2);
}
