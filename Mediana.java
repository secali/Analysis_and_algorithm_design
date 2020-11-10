//Autor: Sergio Cañete Linares
//Análisis de Algoritmos - Grupo 2ºC

public class Mediana {

	//muestra un array delimitado por dos posiciones: inferior y superior
    public static void mostrar_array_delimitado(int [] a,int inf, int sup){
        System.out.print("V: ");
        for(int i=inf; i<sup;i++){
          System.out.print(a[i]+" ");
        }
        System.out.println("\n");

      }


    public static int mediana(int x[], int y[], int infx, int supx, int infy, int supy) {

    	//caso base de 1 elemento, el resultado es el mínimo
        if ((infx>=supx)) return Math.min(x[supx], y[supy]);

        int nelem; //numero de elementos de elementos comprendidos entre el limite inferior y superior del array 
        int centro; //el numero de elementos dividido entre 2, posicion de la mediana
        int posX;   //dependiendo del "subarray" en el que nos encontremos, centro por si solo no no sirve, por eso le sumamos un desplazamiento, el desplazamiento
                    //es la posicion inicial donde comienza el "subarray"
        int posY;   //idem para Y
        int medianaX;   //la mediana del arrayX dada por la posX
        int medianaY;   //idem Y

        //numero de elementos y centro
        nelem = supx - infx + 1;
        centro = (nelem - 1) / 2;

        //calculo de desplazamientos y mediana
        posX = infx + centro;
        posY = infy + centro;

        medianaX = x[posX];
        medianaY = y[posY];


        /*
        TAMBIEN ES POSIBLE DEFINIR COMO CASO BASE LOS ARRAYS DE 2 ELEMENTOS, EN CUYO CASO SERÍA 
        TAL Y COMO SE MUESTRA EN: http://www.lcc.uma.es/~av/Libro/CAP3.pdf
		if(nitems==2){
			if(x[ultX]<y[primY])return x[ultX];
			else if(y[ultY]<x[primX]) return y[ultY];
			else return Math.max(x[primX], y[primY]);

        */


        //debug
        mostrar_array_delimitado(x,infx, supx);
        mostrar_array_delimitado(y,infy, supy);
        System.out.println("PosX: "+posX);
        System.out.println("PosY: "+posY+"\n");
        System.out.println("MedianaX:"+medianaX);
        System.out.println("MedianaY:"+medianaY+"\n"+"----------------------------\n");

        //caso general
        //1)las dos medianas son iguales
        //2)si medianaX < medianaY --> el valor buscado está en la segunda mitad del X y la primera de Y
        //3)Al contrario que el caso 2
        if(medianaX==medianaY)return (x[posX]);
        else if(medianaX<medianaY)return (mediana(x, y, supx-centro,supx,infy,infy+centro));
        else return (mediana(x,y,infx,infx+centro,supy-centro,supy));  
    }

    public static void main(String[] args) {
        int [] a = {1,3,5,6,9,10,12,13,15,16};
        int [] b = {2,4,7,8,11,14,17,18,19,20};


        System.out.println(mediana(a,b,0,a.length,0,b.length));
    }
}