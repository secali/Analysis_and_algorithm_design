public class buscari{
//1. Dado un vector ordenado V de n enteros distintos, escribir un algoritmo que en tiempo
//O(logn) encuentre un n´umero i tal que 1 ≤ i ≤ n y V [i] = i, siempre que exista.


    public static int buscari_dyv(int a[], int inf, int sup){

        int centro = (inf+sup)/2;

        //caso base:
        //cuando se encuentra  v[i]==i se para y se devuelve dicho valor
        //en caso de que no se haya encontrado devuelve -1
        if(a[centro]==centro) return centro;
        if(inf>sup) return -1;

        //como el array esta ordenado, si el elemento del array es mas grande que i, entonces i esta a la izquierda de ese elemento
        if(a[centro]>centro)return buscari_dyv(a, inf, centro-1);
        //al contrario
        else return buscari_dyv(a, centro+1, sup);
    }


    public static void main(String[] args) {
        int [] a = {-3,-1,0,1,2,3,4,7};    

        System.out.println(buscari_dyv(a, 0, a.length));
    }
}
