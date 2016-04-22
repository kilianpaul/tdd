import java.util.Scanner;

class Romain {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        int[] nombres = {1000, 500, 100, 50, 10, 5, 1 };

        String symboles = "MDCLXVI";

        final int MAX = 3999;

        /*Declaration des variables*/

        boolean  bool=false;

        String carChaine, rom;

        String chaine;

        /*                                                         */

        /*do {*/

        System.out.print("Entrez un nombre en chiffres romains : ");

        /*Saisi clavier*/

        chaine= clavier.nextLine();

        chaine=chaine.intern();

        chaine=chaine.toUpperCase();

        /*System.out.println("La valeur entre "+chaine);*/

        /*test de conformite*/

        for(int i=0; i<chaine.length(); ++i){

              carChaine=chaine.substring(i,i+1);

              for(int j=0; j<symboles.length();j++){

                   rom=symboles.substring(j,j+1);

                   if(carChaine.equals(rom))

                      {bool=true;break;}

                   else{bool=false;}

                }

          if(bool==false){System.out.println("Conversion impossible, nombre romain mal formé.");break;}

          }

        /*}while(bool==false);*/

        if(bool){

        /*Conversion*/

        /*Variables*/

        int x=0;

        int p=0; /*Variable permet la soustraction*/

        for(int i=0; i<chaine.length(); ++i){

              carChaine=chaine.substring(i,i+1);

              for(int j=0; j<symboles.length();j++){

                  rom=symboles.substring(j,j+1);

                   if(carChaine.equals(rom))

                     { if(j>=p){x+=nombres[j];

                                p=j;

                         }else{

                               x-=(2*nombres[p]-nombres[j]);

                               p=j;}

                     }

                }

            }

          System.out.println("arabes("+chaine+") = "+x);

       }

       /*Entre chiffre arabes*/

        int arabes=0;

        do {

        System.out.print("Entrez un nombre (en chiffres arabes) compris entre 1 et " + MAX + " : "); 

        /*Saisi clavier*/

        arabes= clavier.nextInt();

        /*System.out.println("La valeur entre "+chaine);*/

        }while(arabes<1 || arabes >3999);

        /*Conversion*/

        int temp=arabes;

        int k=0;

        String conversion="";

        for(int i=0;i< nombres.length;++i){

        if(temp==4){

         temp=0;

         conversion=conversion+"IV";

        }

          while(temp>=nombres[i] && k<3){

            ++k;

           temp=temp-nombres[i];

           conversion=conversion+symboles.charAt(i);

           }

              if(i <nombres.length-1){

               if(temp/nombres[i+1]>1 && (((temp/nombres[i+1])*nombres[i+1])+nombres[i+1])==nombres[i])

            {   

                temp=temp-(nombres[i]-nombres[i+1]);

                conversion=conversion+symboles.charAt(i+1)+symboles.charAt(i);

            }

            }

               if(i<nombres.length-2){

        if(temp/nombres[i+2]>1 && (((temp/nombres[i+2])*nombres[i+2])+nombres[i+2])==nombres[i])

            { 

                temp=temp-(nombres[i]-nombres[i+2]);

                conversion=conversion+symboles.charAt(i+2)+symboles.charAt(i);

            }

            }

         k=0;

        if(temp==0){break;}

             }

        System.out.println("romains("+arabes+") = "+conversion);

    }

}