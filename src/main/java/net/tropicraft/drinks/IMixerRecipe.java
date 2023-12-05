package net.tropicraft.drinks;

public interface IMixerRecipe {

    Ingredient[] getIngredients();

    Drink getCraftingResult();
}
