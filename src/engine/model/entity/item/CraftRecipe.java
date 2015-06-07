package engine.model.entity.item;

/**
 *
 * @author Adrien
 */
public interface CraftRecipe<T>
{
    public boolean matches(CraftingInstance recipe);
    public T generate(CraftingInstance recipe);
}
