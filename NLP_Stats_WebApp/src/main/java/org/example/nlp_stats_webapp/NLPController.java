package org.example.nlp_stats_webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;



@Controller
public class NLPController {
    private Map<String, Double> aggregatedStats;

    // Constructor to read aggregated stats
    public NLPController(@Value("classpath:aggregated_results.csv") Resource aggregatedResultsResource) throws Exception {
        this.aggregatedStats = readAggregatedStats(aggregatedResultsResource);
    }

    // Method to read aggregated stats from a CSV file
    private Map<String, Double> readAggregatedStats(Resource resource) throws Exception {
        Map<String, Double> stats = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(resource.getURI()));
        // Assuming the CSV has a header and one line of data
        String[] headers = lines.get(0).split(",");
        String[] values = lines.get(1).split(",");
        for (int i = 0; i < headers.length; i++) {
            stats.put(headers[i], Double.parseDouble(values[i]));
        }
        return stats;
    }

    // Method to show the form for text input
    @GetMapping("/")
    public String showForm() {
        return "textInputForm";
    }

    @PostMapping("/analyze")
    public String analyzeText(@RequestParam("text") String text, Model model) {
        List<String> words = Arrays.asList(text.split("\\s+"));
        Set<String> uniqueWords = new HashSet<>(words);
        long totalWords = words.size();
        long uniqueWordCount = uniqueWords.size();
        double averageWordLength = words.stream().mapToInt(String::length).average().orElse(0.0);
        List<String> sentences = Arrays.asList(text.split("[.!?]"));
        long sentenceCount = sentences.size();

        String mostFrequentWord = words.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet()
                .stream()
                .max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .get()
                .getKey();

        // Add input stats to the model
        model.addAttribute("inputTotalWords", totalWords);
        model.addAttribute("inputUniqueWordCount", uniqueWordCount);
        model.addAttribute("inputAverageWordLength", averageWordLength);
        model.addAttribute("inputSentenceCount", sentenceCount);
        model.addAttribute("inputMostFrequentWord", mostFrequentWord);

        // Add aggregated stats to the model
        model.addAttribute("aggregatedStats", aggregatedStats);

        // Decide on which view to return based on your application logic
        // For example, you can return "comparisonResult" to show a comparison
        return "comparisonResult";
    }

}
