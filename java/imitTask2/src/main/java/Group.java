public class Group {
    private int id;
    private int[] arrayInt;

    public Group(int id, int ... arrayInt){
        this.id = id;
        this.arrayInt = new int[arrayInt.length];
        for(int i = 0; i<arrayInt.length; i++){
            this.arrayInt[i] = arrayInt[i];
        }
    }
    public Group(Group copy){
        this.id =copy.id;
        this.arrayInt = new int[copy.arrayInt.length];
        for(int i = 0; i<arrayInt.length; i++){
            this.arrayInt[i] = copy.arrayInt[i];
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getArrayInt() {
        return arrayInt;
    }

    public void setArrayInt(int ... arrayInt) {
        this.arrayInt = arrayInt;
    }
    public int getLength(){
        return arrayInt.length;
    }
}

