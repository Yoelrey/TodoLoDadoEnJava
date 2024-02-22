package Refactorizacion;
class Proyectil implements Usado{
     protected enum TipoProyectil {NORMAL, INCENDIARIO, PLATA};
    private boolean gastado = false;
    protected float calibreDeBala=100; // Calibre de la bala
    protected float potenciaInicio = 40;
    TipoProyectil tipoBala;
    int calidad = 10;
 
    boolean estaUsado(){     
        if(gastado) {
            return gastado= true;
        }
        return gastado;
    }
 
    float calculadañodisparo() {
        if(tipoBala == TipoProyectil.NORMAL) 
        	return potenciaInicio * calibreDeBala + calidad;
        	else if(tipoBala == TipoProyectil.INCENDIARIO)
            return potenciaInicio * 8 * calibreDeBala+calidad;
        	else
            return potenciaInicio * 20 * calibreDeBala+calidad;
            
        }
    public void usar() {
    	Usado.super.usar();
    }

    
 
}