public class Jaeger {
    
    private String modelName;
    private Date launched;
    private String mark;
    private String status;
    private double height;
    private int weight;
    private String bodyLanguage;
    private int countKaijuKilled;
    
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setlaunched(Date launched) {
        this.launched = new Date(launched.getTime());
    }

    public Date getlaunched() {
        return new Date(launched.getTime());
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setBodyLanguage(String bodyLanguage) {
        this.bodyLanguage = bodyLanguage;
    }

    public String getBodyLanguage() {
        return bodyLanguage;
    }

    public void setCountKaijuKilled(int countKaijuKilled) {
        this.countKaijuKilled = countKaijuKilled;
    }

    public int getCountKaijuKilled() {
        return countKaijuKilled;
    }


}