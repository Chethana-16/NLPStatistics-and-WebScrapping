# NLPStatistics-and-WebScrapping
This project addresses the following tasks:
1. Python program to scrape about 100 web pages from a single health-related website. For each page calculate at least 5 NLP-related statistics and store
   all the results are in a file.
2.  A file named aggregated_results (1 record), contains the average of
   the 100 statistics.
3.  A simple local web application in Java using a web framework like
   Spring/Play contains one or more web pages. It takes an input of a text in the request and then generates nlp statistics of the text similar to the earlier
   task.
4. A comparison of the statistics between the input text and statistics is returned from the
   earlier task(aggregated_results) on another web page.

The repository contains two folders:
1. "py" folder - contains the Python code for web scrapping and NLP Statistics
2. "NLP_stats_WebApp" folder - contains folders related to the web application. Here, the files to focus on are: **NLP_Stats_WebApp/src/main/java/org/example/nlp_stats_webapp/NLPController.java**, **NLP_Stats_WebApp/src/main/resources/aggregated_results.csv** and **NLP_Stats_WebApp/src/main/resources/templates** which contains three HTML files for analysis results, comparison results and a form for taking the input. 
