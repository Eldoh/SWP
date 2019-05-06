public class WeaponPrototype implements Cloneable{

    private final String type;
    private String name;
    private int dps;
    private int range;
    private int def;
    private boolean cloned;

    public WeaponPrototype(String type, String name, int dps, int range, int def){
        this.type = type;
        this.name = name;
        this.dps = dps;
        this.range = range;
        this.def = def;
    }

    @Override
    public WeaponPrototype clone(){

        WeaponPrototype clone = new WeaponPrototype(this.type, this.name, this.dps, this.range, this.def);
        clone.cloned = true;
        return clone;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDps() {
        return dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
