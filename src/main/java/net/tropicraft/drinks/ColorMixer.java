package net.tropicraft.drinks;

public final class ColorMixer {

    private static ColorMixer instance;

    public static ColorMixer getInstance() {
        return ColorMixer.instance;
    }

    public void normalizeRGBA(final int[] rgba, final float[] result) {
        result[0] = rgba[0] / 255.0f;
        result[1] = rgba[1] / 255.0f;
        result[2] = rgba[2] / 255.0f;
        result[3] = rgba[3] / 255.0f;
    }

    public void denormalizeRGBA(final float[] rgba, final int[] result) {
        result[0] = (int) (255.0f * rgba[0]);
        result[1] = (int) (255.0f * rgba[1]);
        result[2] = (int) (255.0f * rgba[2]);
        result[3] = (int) (255.0f * rgba[3]);
    }

    public void splitRGBA(final long color, final int[] result) {
        result[0] = (int) (color >> 24 & 0xFFL);
        result[1] = (int) (color >> 16 & 0xFFL);
        result[2] = (int) (color >> 8 & 0xFFL);
        result[3] = (int) (color & 0xFFL);
    }

    public long unsplitRGBA(final int[] rgb) {
        return (rgb[0] & 0xFF) << 24 | (rgb[1] & 0xFF) << 16 | (rgb[2] & 0xFF) << 8 | (rgb[3] & 0xFF);
    }

    public void normalizeRGB(final int[] rgb, final float[] result) {
        result[0] = rgb[0] / 255.0f;
        result[1] = rgb[1] / 255.0f;
        result[2] = rgb[2] / 255.0f;
    }

    public void denormalizeRGB(final float[] rgb, final int[] result) {
        result[0] = (int) (255.0f * rgb[0]);
        result[1] = (int) (255.0f * rgb[1]);
        result[2] = (int) (255.0f * rgb[2]);
    }

    public void splitRGB(final int color, final int[] result) {
        result[0] = (color >> 16 & 0xFF);
        result[1] = (color >> 8 & 0xFF);
        result[2] = (color & 0xFF);
    }

    public int unsplitRGB(final int[] rgb) {
        return (rgb[0] & 0xFF) << 16 | (rgb[1] & 0xFF) << 8 | (rgb[2] & 0xFF);
    }

    public void convertRGBToCMYK(final float[] rgb, final float[] cmyk) {
        final float tempC = 1.0f - rgb[0];
        final float tempM = 1.0f - rgb[1];
        final float tempY = 1.0f - rgb[2];
        final float black = Math.min(tempC, Math.min(tempM, tempY));
        final float cyan = (tempC - black) / (1.0f - black);
        final float magenta = (tempM - black) / (1.0f - black);
        final float yellow = (tempY - black) / (1.0f - black);
        cmyk[0] = cyan;
        cmyk[1] = magenta;
        cmyk[2] = yellow;
        cmyk[3] = black;
    }

    public void convertCMYKToRGB(final float[] cmyk, final float[] rgb) {
        final float c = cmyk[0];
        final float m = cmyk[1];
        final float y = cmyk[2];
        final float k = cmyk[3];
        final float nc = c * (1.0f - k) + k;
        final float nm = m * (1.0f - k) + k;
        final float ny = y * (1.0f - k) + k;
        final float r = 1.0f - nc;
        final float g = 1.0f - nm;
        final float b = 1.0f - ny;
        rgb[0] = r;
        rgb[1] = g;
        rgb[2] = b;
    }

    public void convertRYBToRGB(final float[] ryb, final float[] rgb) {
        float r = ryb[0];
        float y = ryb[1];
        float b = ryb[2];
        final float w = Math.min(r, Math.min(y, b));
        r -= w;
        y -= w;
        b -= w;
        final float my = Math.max(r, Math.max(y, b));
        float g = Math.min(y, b);
        y -= g;
        b -= g;
        if (b != 0.0f && g != 0.0f) {
            b *= 2.0f;
            g *= 2.0f;
        }
        r += y;
        g += y;
        final float mg = Math.max(r, Math.max(g, b));
        if (mg != 0.0f) {
            final float n = my / mg;
            r *= n;
            g *= n;
            b *= n;
        }
        r += w;
        g += w;
        b += w;
        rgb[0] = r;
        rgb[1] = g;
        rgb[2] = b;
    }

    public void convertRGBToRYB(final float[] rgb, final float[] ryb) {
        float r = rgb[0];
        float g = rgb[1];
        float b = rgb[2];
        final float w = Math.min(r, Math.min(g, b));
        r -= w;
        g -= w;
        b -= w;
        final float mg = Math.max(r, Math.max(g, b));
        float y = Math.min(r, g);
        r -= y;
        g -= y;
        if (b != 0.0f && g != 0.0f) {
            b /= 2.0f;
            g /= 2.0f;
        }
        y += g;
        b += g;
        final float my = Math.max(r, Math.max(y, b));
        if (my != 0.0f) {
            final float n = mg / my;
            r *= n;
            y *= n;
            b *= n;
        }
        r += w;
        y += w;
        b += w;
        ryb[0] = r;
        ryb[1] = y;
        ryb[2] = b;
    }

    public void mixCMYK(final float[][] cmyks, final float[] result) {
        if (cmyks.length == 0) {
            final int n = 0;
            final int n2 = 1;
            final int n3 = 2;
            final int n4 = 3;
            final float n5 = 0.0f;
            result[n3] = (result[n4] = n5);
            result[n] = (result[n2] = n5);
            return;
        }
        if (cmyks.length == 1) {
            final float[] cmyk = cmyks[0];
            result[0] = cmyk[0];
            result[1] = cmyk[1];
            result[2] = cmyk[2];
            result[3] = cmyk[3];
            return;
        }
        float cTotal = 0.0f;
        float mTotal = 0.0f;
        float yTotal = 0.0f;
        float kTotal = 0.0f;
        float cMax = 0.0f;
        float mMax = 0.0f;
        float yMax = 0.0f;
        float kMax = 0.0f;
        for (final float[] cmyk2 : cmyks) {
            final float c = cmyk2[0];
            final float m = cmyk2[1];
            final float y = cmyk2[2];
            final float k = cmyk2[3];
            cTotal += c;
            mTotal += m;
            yTotal += y;
            kTotal += k;
            cMax = ((c > cMax) ? c : cMax);
            mMax = ((m > mMax) ? m : mMax);
            yMax = ((y > yMax) ? y : yMax);
            kMax = ((k > kMax) ? k : kMax);
        }
        final int count = cmyks.length;
        final float c2 = cTotal / (float) Math.sqrt(count + 1);
        final float i = mTotal / (float) Math.sqrt(count + 1);
        final float y2 = yTotal / (float) Math.sqrt(count + 1);
        final float j = kTotal / (float) Math.sqrt(Math.sqrt(count));
        result[0] = c2;
        result[1] = i;
        result[2] = y2;
        result[3] = j;
    }

    public void mixRYB(final float[][] rybs, final float[] result) {
        if (rybs.length == 0) {
            final int n = 0;
            final int n2 = 1;
            final int n3 = 2;
            final float n4 = 0.0f;
            result[n3] = n4;
            result[n] = (result[n2] = n4);
            return;
        }
        if (rybs.length == 1) {
            final float[] ryb = rybs[0];
            result[0] = ryb[0];
            result[1] = ryb[1];
            result[2] = ryb[2];
            return;
        }
        float rTotal = 0.0f;
        float yTotal = 0.0f;
        float bTotal = 0.0f;
        for (final float[] ryb2 : rybs) {
            rTotal += ryb2[0];
            yTotal += ryb2[1];
            bTotal += ryb2[2];
        }
        final int count = rybs.length;
        float br = rTotal / count;
        final float r = rTotal / (float) Math.sqrt(Math.sqrt(count - br));
        br = yTotal / count;
        final float y = yTotal / (float) Math.sqrt(Math.sqrt(count - br));
        br = bTotal / count;
        final float b = bTotal / (float) Math.sqrt(Math.sqrt(count - br));
        result[0] = r;
        result[1] = y;
        result[2] = b;
    }

    public int mixRGBAsCMYK(final int[] rgbs) {
        final float[][] cmyks = new float[rgbs.length][];
        final int[] tempRGBi = new int[3];
        final float[] tempRGBf = new float[3];
        final float[] tempCMYKf = new float[4];
        for (int i = 0; i < rgbs.length; ++i) {
            final int rgb = rgbs[i];
            this.splitRGB(rgb, tempRGBi);
            this.normalizeRGB(tempRGBi, tempRGBf);
            this.convertRGBToCMYK(tempRGBf, tempCMYKf);
            cmyks[i] = tempCMYKf;
        }
        this.mixCMYK(cmyks, tempCMYKf);
        this.convertCMYKToRGB(tempCMYKf, tempRGBf);
        this.denormalizeRGB(tempRGBf, tempRGBi);
        final int rgb2 = this.unsplitRGB(tempRGBi);
        return rgb2;
    }

    public int mixRGBAsRYB(final int[] rgbs) {
        final float[][] rybs = new float[rgbs.length][];
        final int[] tempRGBi = new int[3];
        final float[] tempRGBf = new float[3];
        final float[] tempRYBf = new float[3];
        for (int i = 0; i < rgbs.length; ++i) {
            final int rgb = rgbs[i];
            this.splitRGB(rgb, tempRGBi);
            this.normalizeRGB(tempRGBi, tempRGBf);
            this.convertRGBToRYB(tempRGBf, tempRYBf);
            rybs[i] = tempRYBf;
        }
        this.mixRYB(rybs, tempRYBf);
        this.convertRYBToRGB(tempRYBf, tempRGBf);
        this.denormalizeRGB(tempRGBf, tempRGBi);
        final int rgb2 = this.unsplitRGB(tempRGBi);
        return rgb2;
    }

    public int alphaBlendRGBA(final int bg, final int fg, final float fgAlpha) {
        final float bgRed = (bg >> 16 & 0xFF) / 255.0f;
        final float bgGreen = (bg >> 8 & 0xFF) / 255.0f;
        final float bgBlue = (bg & 0xFF) / 255.0f;
        final float fgRed = (fg >> 16 & 0xFF) / 255.0f;
        final float fgGreen = (fg >> 8 & 0xFF) / 255.0f;
        final float fgBlue = (fg & 0xFF) / 255.0f;
        final float outRed = fgRed * fgAlpha + bgRed * (1.0f - fgAlpha);
        final float outGreen = fgGreen * fgAlpha + bgGreen * (1.0f - fgAlpha);
        final float outBlue = fgBlue * fgAlpha + bgBlue * (1.0f - fgAlpha);
        final int outRedi = (int) (outRed * 255.0f);
        final int outGreeni = (int) (outGreen * 255.0f);
        final int outBluei = (int) (outBlue * 255.0f);
        return (outRedi & 0xFF) << 16 | (outGreeni & 0xFF) << 8 | (outBluei & 0xFF);
    }

    static {
        ColorMixer.instance = new ColorMixer();
    }
}
