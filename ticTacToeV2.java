import java.util.Scanner;

public class ticTacToeV2 {

   public static String[][] crTab2(){
      String tab[][] = new String[3][3]; 
      tab[0][0] = " ";
      tab[0][1] = " ";
      tab[0][2] = " ";
      tab[1][0] = " ";
      tab[1][1] = " ";
      tab[1][2] = " ";
      tab[2][0] = " ";
      tab[2][1] = " ";
      tab[2][2] = " ";   
      
      return tab;
   }

   public static void imp(String tab[][]){
      //imprimir las barras del tablero.
      for(int i = 0; i < tab.length; i++){
         for(int a = 0; a < tab.length; a++){
         System.out.print("|"+tab[a][i] + "|");
         }
         System.out.println("");
      }
   }

   public static boolean condWin(String tab[][]){
      for(int i = 0; i < 3; i++){
         //columnas
         if(tab[i][0].equals("o") && tab[i][1].equals("o") && tab[i][2].equals("o")){
            return true;
         }
         if( tab[i][0].equals("x") && tab[i][1].equals("x") && tab[i][2].equals("x")){
            return true;
         }
         //filas (terminar)
         if(tab[0][i].equals("o") && tab[1][i].equals("o") && tab[2][i].equals("o")){
            return true;
          }
         if(tab[0][i].equals("x") && tab[1][i].equals("x") && tab[2][i].equals("x")){
             return true;
         }
         //diagonales
         if(tab[0][0].equals("o") && tab[1][1].equals("o") && tab[2][2].equals("o")){
            return true;
         }
         if(tab[0][0].equals("x") && tab[1][1].equals("x") && tab[2][2].equals("x")){
            return true;
         }
         if(tab[0][2].equals("o") && tab[1][1].equals("o") && tab[2][0].equals("o")){
            return true;
         }
         if(tab[0][2].equals("x") && tab[1][1].equals("x") && tab[2][0].equals("x")){
            return true;
         }  
      }
      return false;
   }

   public static void Mov(String [][]arr, int posjugX, String xo){
      int cont = 0;
      for(int i=0; i<arr.length; i++) {
         for(int j=0; j<arr[i].length; j++) {
            cont++;
            if(cont == posjugX){
                arr[j][i] = xo;
             }
         }
      }
   }
      
   public static void main(String[] args) {
      String tablero[][] = crTab2();
      String jugActual = "x";
      boolean jugx = true;
      int posJug = 0;

      imp(tablero);

      while(condWin(tablero) != true){

         if(jugx){
            jugActual = "x";
         }
         else jugActual = "o";


         Scanner scan = new Scanner(System.in);
         System.out.println("le toca al jugador " + jugActual);
         System.out.println("Escribe un numero entre el 1 y el 9");
         posJug = scan.nextInt();

         Mov(tablero, posJug, jugActual);
         imp(tablero);

         jugx = !jugx;
      }
      System.out.println("ENHORABUENA HA GANADO JUGADOR " + jugActual);
   }
}