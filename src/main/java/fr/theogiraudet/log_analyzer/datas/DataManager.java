package fr.theogiraudet.log_analyzer.datas;


public class DataManager {
    
    private enum Datas {
        CONNECTION(new Connection());

        private final Data data;

        Datas(Data data) {
            this.data = data;
        }
    } 

    public static void apply(String line) {
        for(var data : Datas.values())
            if(data.data.isParsable(line))
                data.data.parse(line);
    }

    public static Data get() {
        return Datas.CONNECTION.data;
    }

}
