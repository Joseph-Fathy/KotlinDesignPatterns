import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ComputerStore store = new ComputerStore();
        Computer computer = store.prepareComputer();
        computer.turnOn();
        computer.turnOff();
    }
}

class Computer{
    private List<Component> components = new ArrayList();
    
    public void turnOn(){
        System.out.println("Computer starts..");
        for(Component c:components){
            c.start();
        }
    }
    public void turnOff(){
        System.out.println("Computer is stopping components---------");
         for(Component c:components){
            c.stop();
        }
        System.out.println("Computer is turned Off.");
    }
    
    
    public void addComponent(Component c){
        components.add(c);
    }
}

class ComputerStore{
    public Computer prepareComputer(){
        Computer computer = new Computer();
        Brand dell = new DellFactory().createBrand();
        Brand intel = new IntelFactory().createBrand();
        
        Component cpu = new CpuFactory().createComponent(intel);
        Component storage = new StorageFactory().createComponent(dell);
        
        computer.addComponent(cpu);
        computer.addComponent(storage);
        return computer;
    }
}

//====================== Brands ======================

interface Brand{
    public String getName();
}
//---------------------
class Dell implements Brand{
    public String getName(){
        return "Dell";
    }
}
//---------------------
class Intel implements Brand{
    public String getName(){
        return "Intel";
    }
}

//====================== Components ======================

abstract class Component{
    abstract public Brand getBrand();
    abstract public String getName();
    abstract public void start();
    public void stop(){
        System.out.println(getName()+" from "+getBrand().getName()+" is stopped.");
    }
}
//---------------------
class Cpu extends Component{
    private Brand brand;
    public Cpu(Brand _brand){
        brand= _brand;
    }
    
    public String getName(){
        return "Cpu";
    }
    
    public Brand getBrand(){
        return brand;
    }
    
    public void start(){
        System.out.println(getName()+" from "+getBrand().getName()+" is running..");
    }
}
//---------------------
class Storage extends Component{
    private Brand brand;
    private int sizeInGb;
    
    public Storage(Brand _brand,int _sizeInGb){
        brand= _brand;
        sizeInGb= _sizeInGb;
    }
    
    public String getName(){
        return "Disk Storage";
    }
    
    public Brand getBrand(){
        return brand;
    }
    
    public void start(){
        System.out.println(getName()+" from "+getBrand().getName()+" with size "+sizeInGb+"GB is running..");
    }
}

//====================== Factories ======================
abstract class BrandsFactory{
    abstract Brand createBrand();
}
//---------------------
class DellFactory extends BrandsFactory{
    Brand createBrand(){
        return new Dell();
    }
}
//---------------------
class IntelFactory extends BrandsFactory{
    Brand createBrand(){
        return new Intel();
    }
}

//---------------------
abstract class ComponentsFactory{
    abstract Component createComponent(Brand b);
}
//---------------------
class CpuFactory{
    Component createComponent(Brand b){
        return new Cpu(b);
    }
}
//---------------------
class StorageFactory{
    Component createComponent(Brand b){
        return new Storage(b,256);
    }
}
