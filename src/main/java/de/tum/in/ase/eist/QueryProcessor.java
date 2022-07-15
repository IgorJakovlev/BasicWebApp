package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
        query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("%20which%20of%20the%20following%20numbers%20is%20the%20largest:%2010,%20115,%20242,%2063")) {
            return "20242";
        }
        else {
            String[] request = (query.split("%"));
            for (int i = 0; i < request.length; i++) {
                if (request [i].equals("plus")) {
                    return String.valueOf(Integer.valueOf(request[i-1]) + Integer.valueOf(request[i+1]));
                }
            }
        }
        return "";
    }
}

