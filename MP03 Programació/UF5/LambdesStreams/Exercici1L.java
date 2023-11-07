package LambdesStreams;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Exercici1L {

    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyy");
        Persona p1 = new Persona("Arya", Persona.Genere.DONA, LocalDate.parse("25/12/2002", format));
        Persona p2 = new Persona("Tyrion", Persona.Genere.HOME, LocalDate.parse("12/10/1980", format));
        Persona p3 = new Persona("Cersei", Persona.Genere.DONA, LocalDate.parse("10/01/1984", format));
        Persona p4 = new Persona("Eddard", Persona.Genere.HOME, LocalDate.parse("24/04/1974", format));
        Persona p5 = new Persona("Sansa", Persona.Genere.DONA, LocalDate.parse("24/04/1992", format));
        Persona p6 = new Persona("Jaime", Persona.Genere.HOME, LocalDate.parse("24/04/1979", format));
        Persona p7 = new Persona("Khal", Persona.Genere.HOME, LocalDate.parse("10/08/1979", format));
        Persona p8 = new Persona("Daenerys", Persona.Genere.DONA, LocalDate.parse("12/11/1992", format));
        Persona p9 = new Persona("Davos", Persona.Genere.HOME, LocalDate.parse("12/11/1965", format));
        Persona p10 = new Persona("Jon Neu", Persona.Genere.HOME, LocalDate.parse("12/11/1986", format));
        Persona p11 = new Persona("Brienne", Persona.Genere.DONA, LocalDate.parse("12/11/1989", format));

        Persona[] lpers = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};
        List<Persona> llistaPersones;
        llistaPersones = new ArrayList<>(Arrays.asList(lpers));
        Map<Integer, Integer> mapPersones = new HashMap<>();

        // 1 - Canviar a lambda

        System.out.println("\n1 - Canviar a Lambda");
        llistaPersones.sort((o1, o2) -> {
            if (o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
            else return -1;
        });

        // 2 - Canviar a Lambda

        System.out.println("\n2 - Canviar a Lambda");
        for (Persona p : llistaPersones) {
            System.out.println(p);
        }

        // 3 - Canvia a classe anònima
        // ordenació alfabètica inversa del nom

        System.out.println("\n3 - ordenació alfabètica inversa del nom");
        llistaPersones.sort((o1, o2) -> o2.getNom().compareTo(o1.getNom()));


        // 4 - fes servir un reference method en comptes del for-loop

        System.out.println("\n4 - fes servir un reference method en comptes del for-loop");
        for (Persona p : llistaPersones) {
            System.out.println(p);
        }


        // 5 - Omplir map. Canviar el for-llop per un forEach amb lambda

        for (Persona per : llistaPersones) {
            mapPersones.put(per.getAge(), 1);
        }
        System.out.println("\n5 - omplir map amb forEach amb lambda");

        // 6 - Canvia el for-loop per un recorregut forEach amb lambda

        System.out.println("\n6 - canvia el for-loop per forEach amb lambda");
        for (Map.Entry entry : mapPersones.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        /* 7 -
            Esbrina com s'utilitzen i perquè serveixen els mètodes de map següents
                map.putIfAbsent
                map.computeIfAbsent
                map.computeIfPresent

             afegeix al map la freqüència d'edat de les persones, de la llistaPersones

             **Si vols fes-ho primer sense els mètodes anomenats i sense lambdes
             i després amb els mètodes i amb lambdes**

             La sortida és aquesta:
                34 anys -> 1
                38 anys -> 1
                39 anys -> 2
                26 anys -> 2
                44 anys -> 1
                15 anys -> 1

         */
        System.out.println("\n7 - Freqüència d'edat de les persones");

        // Crear un HashMap para almacenar la frecuencia de las edades
        Map<Integer, Integer> freqEdats = new HashMap<>();

        // Recorrer la lista de personas y actualizar la frecuencia
        for (Persona persona : llistaPersones) {
            int edat = persona.getAge();

            // Utilizar map.computeIfPresent para incrementar la frecuencia si la clave ya existe
            freqEdats.computeIfPresent(edat, (key, oldValue) -> oldValue + 1);

            // Utilizar map.computeIfAbsent para agregar una nueva clave si no existe y establecer la frecuencia en 1
            freqEdats.putIfAbsent(edat, 1);

            // Utilizar map.putIfAbsent para asegurarse de que la clave existe y, si no existe, establecer la frecuencia en 0
            freqEdats.putIfAbsent(edat, 0);
        }

        // Imprimir las frecuencias de las edades
        System.out.println("Frecuencia de edades de las personas:");
        freqEdats.forEach((edat, freq) -> System.out.println(edat + " años -> " + freq));


        // STREAMS

        // 8 - llistat de persones DONA amb lambda (stream)

        System.out.println("\n8 - Llistat de persones DONA");

        List<Persona> donaList = llistaPersones.stream()
                .filter(persona -> persona.getGenere() == Persona.Genere.DONA)
                .toList(); // Convierte el resultado en una lista

        System.out.println("Personas de género 'DONA':");
        for (Persona persona : donaList) {
            System.out.println(persona);
        }

        // 9 - Llistat dels dos HOMES més joves (stream)

        System.out.println("\n9 - Llistat dels dos HOMES més joves");

        List<Persona> homesMesJoves = llistaPersones.stream()
                .filter(persona -> persona.getGenere() == Persona.Genere.HOME)
                .sorted(Comparator.comparing(Persona::getAge))
                .limit(2)
                .toList();

        System.out.println("Los dos hombres más jóvenes:");
        for (Persona persona : homesMesJoves) {
            System.out.println(persona);
        }

        // 10- Esborrar (no filtrar o imprimir) del llistat les persones entre 30 i 40 anys (amb lambda)

        System.out.println("\n10 - Esborrar (no filtrar o imprimir) del llistat les persones entre 30 i 40 anys");

        llistaPersones.removeIf(persona -> persona.getAge() >= 30 && persona.getAge() <= 40);

        System.out.println("Lista de personas sin edades entre 30 y 40 años:");
        for (Persona persona : llistaPersones) {
            System.out.println(persona);
        }

        // 11 - Persones que tinguin una 'a' al seu nom

        System.out.println("\n11 - Persones que tinguin una 'a' al seu nom");

        List<Persona> personesAmbA = llistaPersones.stream()
                .filter(persona -> persona.getNom().contains("a"))
                .toList();

        System.out.println("Personas con una 'a' en su nombre:");
        for (Persona persona : personesAmbA) {
            System.out.println(persona);
        }

        //12 - Llistat de les dates de naixament + dos dies

        System.out.println("\n12 - Llistat de les dates de naixament + dos dies");

        List<LocalDate> datesNaixament = llistaPersones.stream()
                .map(Persona::getDataNaixament)
                .map(data -> data.plusDays(2))
                .toList();

        System.out.println("Fechas de nacimiento + 2 días:");
        for (LocalDate data : datesNaixament) {
            System.out.println(data);
        }

        //13 - Rejovenir dos anys a totes les persones

        System.out.println("\n13 - Rejovenir dos anys a totes les persones");

        llistaPersones
                .forEach(persona -> persona.setDataNaixament(persona.getDataNaixament().minusYears(2)));

        System.out.println("Lista de personas rejuvenecidas 2 años:");
        for (Persona persona : llistaPersones) {
            System.out.println(persona);
        }

        //14. A partir de la següent llista de noms d'alumnes crea una nova llista d'alumnes amb aquests alumnes nous
        // pots modificar la classe alumne si cal. I imprimeix la llista dels nous alumnes

        System.out.println("\n14 - Alumnes nous");

        List<String> alumnesNous = Arrays.asList("Pedro", "Pablo", "Bilma");

        //Creem una llista de persones amb els alumnes nous
        List<Persona> llistaAlumnesNous = new ArrayList<>();
        for (String nom : alumnesNous) {
            llistaAlumnesNous.add(new Persona(nom, Persona.Genere.HOME, LocalDate.now()));
        }

        //Imprimim la llista de persones amb els alumnes nous
        System.out.println("Lista de alumnos nuevos:");
        for (Persona persona : llistaAlumnesNous) {
            System.out.println(persona);
        }


        //Creem cotxes i els assignem a les diferents persones
        Cotxe c1 = new Cotxe("Seat Ibiza");
        Cotxe c2 = new Cotxe("Seat Leon");
        Cotxe c3 = new Cotxe("Seat Arona");
        Cotxe c4 = new Cotxe("Toyota Auris");
        Cotxe c5 = new Cotxe("Toyota Corolla");
        Cotxe c6 = new Cotxe("Toyota Yaris");
        p1.setCotxe(c1);
        p2.setCotxe(c2);
        p3.setCotxe(c1);
        p4.setCotxe(c3);
        p5.setCotxe(c4);
        p6.setCotxe(c4);
        p7.setCotxe(c5);
        p8.setCotxe(c6);
        p9.setCotxe(c5);
        p10.setCotxe(c3);
        p11.setCotxe(c2);


        //15. Crear una llista de persones amb el coxes de la marca Seat i una altra
        // amb les persones que tenen un Toyota. Fes servir streams
        // imprimeix les dues llistes per ordenades per l'edat de les persones

        System.out.println("\n15 - Persones amb Seat i Toyota");

        List<Persona> personesSeat = llistaPersones.stream()
                .filter(persona -> persona.getCotxe().getMarca().contains("Seat"))
                .sorted(Comparator.comparing(Persona::getAge))
                .toList();

        List<Persona> personesToyota = llistaPersones.stream()
                .filter(persona -> persona.getCotxe().getMarca().contains("Toyota"))
                .sorted(Comparator.comparing(Persona::getAge))
                .toList();

        System.out.println("Personas con coche Seat:");
        for (Persona persona : personesSeat) {
            System.out.println(persona);
        }

        System.out.println("Personas con coche Toyota:");
        for (Persona persona : personesToyota) {
            System.out.println(persona);
        }


        //16. Imprimeix les persones ordenades per ordre alfabètic de la marca dels cotxes
        System.out.println("\n16 - Persones ordenades per ordre alfabètic de la marca dels cotxes");

        List<Persona> personesOrdenadesPerMarca = llistaPersones.stream()
                .sorted(Comparator.comparing(persona -> persona.getCotxe().getMarca()))
                .toList();

        System.out.println("Personas ordenadas por marca de coche:");
        for (Persona persona : personesOrdenadesPerMarca) {
            System.out.println(persona);


        }


    }
}
