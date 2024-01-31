# NLPStatistics-and-WebScrapping
This project addresses the following tasks:
1. Python program to scrape about 100 web pages from a single health-related website. For each page calculate at least 5 NLP-related statistics and store
   all the results in a file.
2.  A file named aggregated_results (1 record), contains the average of
   the 100 statistics.
3.  A simple local web application in Java using a web framework like
   Spring/Play containing one or more web pages. It takes an input of a text in the request and then generate nlp statistics of the text similar to the earlier
   task.
4. A comparison of the statistics between the input text and statistics is returned from the
   earlier task(aggregated_results) in another web page.

The folder named **"py"** contains all the files which include, **webscrap.ipynb** file with the python code for web scrapping and calculating NLP statistics, **nlp_stats.csv** file which contains the results and **webscrap folder** which in turn contains all the files related to the web application. 
The **webscrap folder** inside the py folder contains the **aggregated_results.csv** (in **src/main/resources/templates**). 
