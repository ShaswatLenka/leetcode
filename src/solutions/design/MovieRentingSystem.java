package solutions.design;

/**
 * 1912: Design Movie Renting System
 */

import java.util.*;


class MovieEntry implements Comparable<MovieEntry> {
    int shop;
    int movie;
    int price;
    boolean isRented = false;

    public MovieEntry(int shop, int movie, int price) {
        this.shop = shop;
        this.movie = movie;
        this.price = price;
    }

    public void rentMovie() {
        this.isRented = true;
    }

    public void returnMovie() {
        this.isRented = false;
    }

    @Override
    public int compareTo (MovieEntry other) {
        if (this.price != other.price) {
            return Integer.compare(this.price, other.price);
        } else {
            if (this.shop != other.shop) {
                return Integer.compare(this.shop, other.shop);
            } else {
                return Integer.compare(this.movie, other.movie);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MovieEntry m = (MovieEntry) o;
        return this.shop == m.shop && this.movie == m.movie && this.price == m.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shop, movie, price);
    }
}

// Copy = Shop + Movie
class Copy {
   int shop;
   int movie;
   public Copy (int shop, int movie) {
       this.shop = shop;
       this.movie = movie;
   }

    @Override
    public int hashCode() {
        return Objects.hash(shop, movie);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Copy c = (Copy) o;
        return this.shop == c.shop && this.movie == c.movie;
    }
}

public class MovieRentingSystem {
    TreeSet<MovieEntry> RentedEntries = new TreeSet<>();
    Map<Copy, Integer[]> copies = new HashMap<>();
    Map<Copy, Integer[]> rentedCopies = new HashMap<>();

    Map<Integer, TreeSet<MovieEntry>> movieSearch = new HashMap<>();

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entry: entries) {
            MovieEntry newMovieEntry = new MovieEntry(entry[0], entry[1], entry[2]);
            movieSearch.putIfAbsent(entry[1], new TreeSet<>());
            movieSearch.get(entry[1]).add(newMovieEntry);
            Copy c = new Copy(entry[0], entry[1]);
            if (!copies.containsKey(c)) {
                copies.put(c, new Integer[]{1, entry[2]});
            } else {
                copies.put(c, new Integer[] {copies.get(c)[0] + 1, copies.get(c)[1]});
            }
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        int limit = Math.min(5, movieSearch.get(movie).size());
        for (MovieEntry entry: movieSearch.get(movie)){
           if (count == limit) break;
           result.add(entry.shop);
           count++;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        Copy c = new Copy(shop, movie);
        int price = copies.get(c)[1];
        int count = copies.get(c)[0];
        MovieEntry m = new MovieEntry(shop, movie, price);
        copies.put(c, new Integer[]{count - 1, price});
        rentedCopies.putIfAbsent(c, new Integer[]{0, price});
        rentedCopies.get(c)[0] += 1;
        if (count == 1) {
            movieSearch.get(movie).remove(m);
            RentedEntries.add(m);
        }
    }

    public void drop(int shop, int movie) {
        Copy c = new Copy(shop, movie);
        int price = rentedCopies.get(c)[1];
        int count = rentedCopies.get(c)[0];
        MovieEntry m = new MovieEntry(shop, movie, price);
        copies.put(c, new Integer[]{copies.get(c)[0] + 1, price});
        rentedCopies.put(c, new Integer[]{count - 1, price});
        if (copies.get(c)[0] == 1) {
            movieSearch.get(movie).add(m);
        }
        if (count == 1) {
            RentedEntries.remove(m);
        }
    }

    public List<List<Integer>> report() {
        List<List<Integer>> report = new ArrayList<>();
        int count = 0;
        int limit = Math.min(5, RentedEntries.size());
        for (MovieEntry entry: this.RentedEntries) {
            List<Integer> res = new ArrayList<>();
            if (count == limit) break;
            res.add(entry.shop);
            res.add(entry.movie);
            report.add(res);
            count++;
        }
        return report;
    }

    public static void main(String[] args) {
        MovieRentingSystem m = new MovieRentingSystem(3, new int[][]{{0,1,5}, {0,2,6}, {0,3,7}, {1,1,4}, {1,2,7}, {2,1,5}});
        System.out.println(m.search(1));
        m.rent(0,1);
        m.rent(1,2);
        System.out.println(m.report());
        m.drop(1,2);
        System.out.println(m.search(2));
    }
}
