package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

//        DrawShape drawShape = new DrawSquare();
//        SquareRequest squareRequest = new SquareRequest(drawShape);

//        Injector injector = Guice.createInjector(new DrawSquareModule());
//        SquareRequest squareRequest = injector.getInstance(SquareRequest.class);

//        Weld weld = new Weld();
//        var container = weld.initialize();
//        SquareRequest squareRequest = container.select(SquareRequest.class).get();
//        squareRequest.makeRequest();
//        container.shutdown();

//        Lambda expression

        Maths maths = (a, b) -> { return a + b;};
        UseMaths useMaths = new UseMaths();
        double result = useMaths.add(maths, 2, 2);
        System.out.println(result);

//        Streams API

        // terminal
        // non-terminal

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Marc");
        arrayList.add("Edu");
        arrayList.add("Ervin");

        ArrayList<String> arrList1 = new ArrayList<>() {
            {
                add("Marc");
                add("Edu");
                add("Ervin");
            }
        };

        ArrayList<String> arrList2 = new ArrayList<>(Arrays.asList("Marc", "Edu", "Ervin"));
        ArrayList<String> arrList3 = new ArrayList<>(List.of("Marc", "Edu", "Ervin"));

        long count = arrayList
            .stream()
            .map(name -> {
                return name.toUpperCase();
            }) // listener / non-terminal
            .count();
        System.out.println("COUNT OF NAME: " + count);


        // non terminal

        // Filter
        arrayList
            .stream()
            .filter(name -> name.length() > 3)
            .map(String::toUpperCase)
            .forEach(System.out::println);

        Stream<String> filteredStringStream = arrayList
            .stream()
            .filter(name -> name.length() > 3)
            .map(String::toUpperCase);

        filteredStringStream.forEach(System.out::println);

        // flatMap
        System.out.println("=== FLAT MAP ===");
        Stream<String> flatMapArr = Arrays.stream( new String[]{"Marc is an EM", "Edu is a TL", "Ervin is Ervin"});
        Arrays
            .stream( new String[]{"Marc is an EM", "Edu is a TL", "Ervin is Ervin"})
            .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
            .forEach(System.out::println);


        System.out.println("=== DISTINCT ===");
        Stream<String> distinctStream = Arrays.stream( new String[]{"Marc", "Edu", "Ervin", "Ervin"});
        distinctStream
            .distinct()
            .forEach(System.out::println);


        System.out.println("=== LIMIT ===");
        Stream<String> limit = Arrays.stream( new String[]{"Marc", "Edu", "Ervin", "Ervin"});
        limit
            .limit(2)
            .forEach(System.out::println);

        System.out.println("=== PEEK ===");
        Stream<String> peekStream = Arrays.stream( new String[]{"Marc", "Edu", "Ervin"});
        peekStream
            .peek(System.out::println)
            .forEach(System.out::println);

        // terminal

        System.out.println("=== ANY MATCH ===");
        Stream<String> anyMatchStream = Arrays.stream( new String[]{"Marc", "Edu", "Ervin"});
        boolean anyMatch = anyMatchStream
            .anyMatch(name -> name.startsWith("E"));
        System.out.println(anyMatch);

        System.out.println("=== ALL MATCH ===");
        Stream<String> allMatchStream = Arrays.stream( new String[]{"Marc", "Edu", "Ervin"});
        boolean allMatch = allMatchStream
            .allMatch(name -> name.length() > 2);
        System.out.println(allMatch);

        System.out.println("=== NONE MATCH ===");
        Stream<String> noneMatchStream = Arrays.stream( new String[]{"Marc", "Edu", "Ervin"});
        boolean noneMatch = noneMatchStream
            .noneMatch(name -> name.length() > 2);
        System.out.println(noneMatch);

        System.out.println("=== COLLECT ===");
        Stream<String> collectStream = Arrays.stream( new String[]{"Marc", "Edu", "Ervin"});
        List<String> collect = collectStream
            .map(String::toLowerCase)
            .collect(Collectors.toList());

        System.out.println(collect);

        System.out.println("=== COUNT ===");
        Stream<String> countStream = Arrays.stream( new String[]{"Marc", "Edu", "Ervin"});
        Long countOfNames = countStream
            .count();
        System.out.println(countOfNames);


        System.out.println("=== FIND ANY ===");
        Stream<String> findAnyStream = Arrays.stream( new String[]{});
        Optional<String> anyStreamAny = findAnyStream
            .findAny();
//        System.out.println(anyStreamAny.get());
        System.out.println(anyStreamAny.isPresent() ? anyStreamAny.get() : "None Found");
        System.out.println(anyStreamAny.orElse("None Found"));

        System.out.println("=== FIND FIRST ===");
        Stream<String> findFirstStream = Arrays.stream( new String[]{"Marc", "Edu", "Ervin"});
        Optional<String> findFirstOptional = findFirstStream
            .findFirst();
//        System.out.println(anyStreamAny.get());
        System.out.println(findFirstOptional.isPresent() ? findFirstOptional.get() : "None Found");
        System.out.println(findFirstOptional.orElse("None Found"));

        System.out.println("=== FOREACH ===");
        Stream<String> foreachStream = Arrays.stream( new String[]{"Marc", "Edu", "Ervin"});
        foreachStream
            .forEach(System.out::println);

        System.out.println("=== MIN ===");
        Stream<String> minStream = Arrays.stream( new String[]{"Marc", "Edu", "Ervin"});
        Optional<String> minOptional = minStream
            .min((v1, v2) -> {
                return v1.compareTo(v2);
            });
        System.out.println(minOptional.orElse("No min"));

        System.out.println("=== MAX ===");
        Stream<Integer> maxStream = Arrays.stream(new Integer[]{11, 11, 11});
        Optional<Integer> maxOptional = maxStream
            .max((v1, v2) -> {
                return v1.compareTo(v2);
            });
        System.out.println(maxOptional.orElse(0));


        System.out.println("=== REDUCE ===");
        Stream<String> reduceStream = Arrays.stream(new String[]{"Marc", "is", "an", "EM"});
        Optional<String> reduceOptional = reduceStream
            .reduce((finalVal, val) -> {
                return finalVal + " " + val;
            });
        System.out.println(reduceOptional.orElse("None reduced"));

        System.out.println("=== TO ARRAY ===");
        Stream<String> toArrStream = Stream
            .<String>builder()
            .add("Marc")
            .add("is")
            .add("an")
            .add("EM")
            .build();
        System.out.println(Arrays.toString(toArrStream.toArray()));

        System.out.println("=== STREAM FROM STRING ===");
        Stream<String> stringStream = Stream.of("We", "all", "love", "JAVA");

        stringStream.skip(1).forEach(System.out::println);

        String strJoining = Arrays
            .stream(new String[]{"Marc", "is", "nice"})
            .collect(Collectors.joining(", ", "{", "}"));
        System.out.println(strJoining);

        Product p1 = new Product();
        p1.setCategory("CAT1");
        p1.setPrice(10);
        p1.setDescription("This is P1");

        Product p2 = new Product();
        p2.setCategory("CAT1");
        p2.setPrice(12);
        p2.setDescription("This is P2");

        Product p3 = new Product();
        p3.setCategory("CAT2");
        p3.setPrice(22);
        p3.setDescription("This is P3");

        Product p4 = new Product();
        p4.setCategory("CAT2");
        p4.setPrice(42);
        p4.setDescription("This is P4");

        Stream<Product> prodListStream = Stream.of(p1, p2, p3, p4);
        Map<String, List<Product>> groupedProducts = prodListStream
            .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println(groupedProducts);

        Stream<Product> prodListStreamForPartition = Stream.of(p1, p2, p3, p4);
        Map<Boolean, List<Product>> partitionedProds = prodListStreamForPartition.collect(
            Collectors.partitioningBy(prod -> prod.getPrice() > 10));
        System.out.println(partitionedProds);

        Stream<Product> prodListStreamForSummarizing = Stream.of(p1, p2, p3, p4);
        DoubleSummaryStatistics doubleSummaryStatistics = prodListStreamForSummarizing.collect(
            Collectors.summarizingDouble(Product::getPrice));

        System.out.println("GET AVERAGE: " + doubleSummaryStatistics.getAverage());
        System.out.println("GET MIN: " + doubleSummaryStatistics.getMin());


        Stream<Product> prodListStreamForAveraging = Stream.of(p1, p2, p3, p4);
        Double averagePrice = prodListStreamForAveraging.collect(
            Collectors.averagingDouble(Product::getPrice));
        System.out.println("AVERAGE: "+averagePrice);

    }
}

class Product {
    private Long id;
    private String category;
    private double price;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
