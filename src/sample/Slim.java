package sample;

public class Slim {
    private String addr;
    private String ndom;
    private String idom;

    public void setAddr(String str){
        addr = str;
    }
    public void setNdom(String str){
        ndom = str;
    }
    public void setIdom(String str){
        idom = str;
    }

    public String getAddr() {
        return addr;
    }

    public String getNdom() {
        return ndom;
    }

    public String getIdom() {
        return idom;
    }

    public String SlimGetAll(){
        return addr + " " + ndom + " " + idom + " ";
    }

}
