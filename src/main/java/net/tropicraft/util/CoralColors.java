package net.tropicraft.util;

public enum CoralColors
{
    CORAL(0, -26447), 
    GREEN(1, -13369403), 
    BLACK(2, -11250604), 
    MINERAL(3, 16777215);
    
    private static final CoralColors[] coralColors;
    public int metadata;
    public int color;
    
    private CoralColors(final int meta, final int c) {
        this.metadata = meta;
        this.color = c;
    }
    
    public static int getColor(final int meta) {
        return CoralColors.coralColors[meta % CoralColors.coralColors.length].color;
    }
    
    static {
        coralColors = new CoralColors[values().length];
        for (final CoralColors color : values()) {
            CoralColors.coralColors[color.metadata] = color;
        }
    }
}
