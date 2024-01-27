public abstract class Character {
    protected abstract void pickUpWeapon();

    protected abstract void defenseAction();

    protected abstract void moveToSafety();

    public void defendAgainstAttack() {
        pickUpWeapon();
        defenseAction();
        moveToSafety();
        System.out.println();
    }
}
