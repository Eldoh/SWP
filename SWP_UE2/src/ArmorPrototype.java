public class ArmorPrototype extends Item{

    private int def;
    private int weight;
    private boolean cloned;

    public ArmorPrototype(String type, String name, int def, int weight){
        super.setType(type);
        super.setName(name);
        this.def = def;
        this.weight = weight;
    }

    @Override
    public ArmorPrototype clone(){
        ArmorPrototype clone = new ArmorPrototype(super.getType(), super.getName(), this.def, this.weight);
        clone.cloned = true;
        return clone;
    }

    public String getType() {
        return super.getType();
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
