public class Data {
    private String id;
    private Group[] group;

    public Data(String id, Group ... group){
        this.id = id;
        group = new Group[group.length];
        for(int i = 0; i< group.length; i++){
            this.group[i] = new Group(group[i]);

        }
    }
}
