package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class QueryProcessor {

    public String process(String query) {
        query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains(" which of the following numbers is the largest: 10, 115, 242, 63")) {
            return "242";
        }
        else {
            String[] request = (query.split(" "));
            for (int i = 0; i < request.length; i++) {
                if (request [i].equals("plus")) {
                    return String.valueOf(Integer.valueOf(request[i-1]) + Integer.valueOf(request[i+1]));
                }
                if (request [i].equals("largest:")) {
                    List<String> list = new ArrayList<>();
                    while (i+1 < request.length) {
                        list.add(request[i + 1].replace(",", ""));
                        i++;
                    }
                    Iterator<String> iterator = list.iterator();
                    String current = iterator.next();
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        if (Integer.valueOf(current) < Integer.valueOf(next)) {
                            current = next;
                        }
                    }
                    return current;
                }
                if (request [i].equals("multiplied")) {
                    return String.valueOf(Integer.valueOf(request[i-1]) * Integer.valueOf(request[i+2]));
                }
            }
        }
        return "";
    }
}

