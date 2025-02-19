public class Razen extends Alienigena{

 /*@author Leydi*/
double grdInvisibilidad;
 
 public void(double grdInvsibilidad,String tipo){
      super(tipo)
      this.grdInvisibilidad= grdInvisibilidad;    
 }

public void setGrdInvisibilidad(double grdInvisibilidad ){
   this.grdInvisibilidad=grdInvisibilidad;
}
public Double getgrdInvisibilidad(){
   return grdInvisibilidad;
}


 @Override
 public int Duermen{
    retunr 10;
 }

 @Override
 public String Comen{
    return "Estan comiendo";
 }
 
 @Override
 public String Atacan{
    return "Estan atacando";
 }
   
}