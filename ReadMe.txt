{\rtf1\ansi\ansicpg1252\cocoartf1671
{\fonttbl\f0\fswiss\fcharset0 Helvetica-Bold;\f1\fswiss\fcharset0 Helvetica;\f2\fnil\fcharset0 LucidaGrande;
\f3\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red0\green128\blue128;\red63\green127\blue127;\red63\green95\blue191;
}
{\*\expandedcolortbl;;\csgenericrgb\c0\c50196\c50196;\csgenericrgb\c24706\c49804\c49804;\csgenericrgb\c24706\c37255\c74902;
}
{\*\listtable{\list\listtemplateid1\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{square\}}{\leveltext\leveltemplateid1\'01\uc0\u9642 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid1}
{\list\listtemplateid2\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{square\}}{\leveltext\leveltemplateid101\'01\uc0\u9642 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid2}
{\list\listtemplateid3\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{square\}}{\leveltext\leveltemplateid201\'01\uc0\u9642 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid3}
{\list\listtemplateid4\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{square\}}{\leveltext\leveltemplateid301\'01\uc0\u9642 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid4}}
{\*\listoverridetable{\listoverride\listid1\listoverridecount0\ls1}{\listoverride\listid2\listoverridecount0\ls2}{\listoverride\listid3\listoverridecount0\ls3}{\listoverride\listid4\listoverridecount0\ls4}}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\b\fs28 \cf0 Predictive Analytics Assignment 2, Readme file.
\f1\b0\fs24 \
Author and Creator of Project - Inavamsi Enaganti, <ibe214@nyu.edu>\
\

\f0\b Tools used:
\f1\b0 \
\pard\tx220\tx720\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\li720\fi-720\pardirnatural\partightenfactor0
\ls1\ilvl0\cf0 {\listtext	
\f2 \uc0\u9642 
\f1 	}Stanford CoreNLP - to install visit https://stanfordnlp.github.io/CoreNLP/index.html#download\
\pard\tx220\tx720\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\li720\fi-720\pardirnatural\partightenfactor0
\ls2\ilvl0\cf0 {\listtext	
\f2 \uc0\u9642 
\f1 	}Eclipse - IDE for Java code\
\pard\tx220\tx720\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\li720\fi-720\pardirnatural\partightenfactor0
\ls3\ilvl0\cf0 {\listtext	
\f2 \uc0\u9642 
\f1 	}To use Stanford CoreNLP on Eclipse using Maven- http://www.sfs.uni-tuebingen.de/~keberle/NLPTools/presentations/CoreNLP/NLP%20Tools%20-%20Stanford%20CoreNLP%20-%20Installation%20(1).pdf\
\pard\tx220\tx720\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\li720\fi-720\pardirnatural\partightenfactor0
\ls4\ilvl0\cf0 {\listtext	
\f2 \uc0\u9642 
\f1 	}ClustVis - Visualise Data - https://biit.cs.ut.ee/clustvis/\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0
\cf0 \

\f0\b Aim:
\f1\b0  Clustering a given set of Documents using Means and Kmeans++\
\

\f0\b\fs28 Running the Project in Eclipse IDE:
\f1\b0\fs24 \
Load App.java and run it(it contains the main method). Located at PA2\uc0\u8297 /src\u8297 /main/\u8296 java/PA2NLP\u8297 
\f2 /
\f1 PA2\uc0\u8297 /App.java\

\f0\b Required files from folder
\f1\b0 : readFile.java, Preprocess.java, Merge.Java, Matrix.java, kmeans.java, kmeanspp.java, csv.java, data.txt, pom.xml  \

\f0\b Dependency files: \
\pard\pardeftab720\partightenfactor0

\f3\b0 \cf0  \cf2 <\cf3 dependencies\cf2 >\cf0 \
    \cf2 <\cf3 dependency\cf2 >\cf0 \
      \cf2 <\cf3 groupId\cf2 >\cf0 junit\cf2 </\cf3 groupId\cf2 >\cf0 \
      \cf2 <\cf3 artifactId\cf2 >\cf0 junit\cf2 </\cf3 artifactId\cf2 >\cf0 \
      \cf2 <\cf3 version\cf2 >\cf0 3.8.1\cf2 </\cf3 version\cf2 >\cf0 \
      \cf2 <\cf3 scope\cf2 >\cf0 test\cf2 </\cf3 scope\cf2 >\cf0 \
    \cf2 </\cf3 dependency\cf2 >\cf0 \
    \cf2 <\cf3 dependency\cf2 >\cf0 \
	  \cf2 <\cf3 groupId\cf2 >\cf0  edu.stanford.nlp \cf2 </\cf3 groupId\cf2 >\cf0  \cf2 <\cf3 artifactId\cf2 >\cf0  stanford-corenlp \cf2 </\cf3 artifactId\cf2 >\cf0  \cf2 <\cf3 version\cf2 >\cf0 3.8.0\cf2 </\cf3 version\cf2 >\cf0 \
    \cf2 </\cf3 dependency\cf2 >\cf0 \
    \cf2 <\cf3 dependency\cf2 >\cf0 \
	  \cf2 <\cf3 groupId\cf2 >\cf0  edu.stanford.nlp \cf2 </\cf3 groupId\cf2 >\cf0  \cf2 <\cf3 artifactId\cf2 >\cf0  stanford-corenlp \cf2 </\cf3 artifactId\cf2 >\cf0  \cf2 <\cf3 version\cf2 >\cf0 3.8.0\cf2 </\cf3 version\cf2 >\cf0 \
	  \cf2 <\cf3 classifier\cf2 >\cf0  models-english \cf2 </\cf3 classifier\cf2 >\cf0 \
    \cf2 </\cf3 dependency\cf2 >\cf0 \
    \cf2 <\cf3 dependency\cf2 >\cf0 \
    \cf2 <\cf3 groupId\cf2 >\cf0  org.apache.cassandra\cf2 </\cf3 groupId\cf2 >\cf0 \
    \cf2 <\cf3 artifactId\cf2 >\cf0 cassandra-all\cf2 </\cf3 artifactId\cf2 >\cf0 \
    \cf2 <\cf3 version\cf2 >\cf0 0.8.1\cf2 </\cf3 version\cf2 >\cf0 \
	\cf2 </\cf3 dependency\cf2 >\cf0 \
	\cf4 <!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->\cf0 \
	\cf2 <\cf3 dependency\cf2 >\cf0 \
	    \cf2 <\cf3 groupId\cf2 >\cf0 ch.qos.logback\cf2 </\cf3 groupId\cf2 >\cf0 \
	    \cf2 <\cf3 artifactId\cf2 >\cf0 logback-classic\cf2 </\cf3 artifactId\cf2 >\cf0 \
	    \cf2 <\cf3 version\cf2 >\cf0 1.0.13\cf2 </\cf3 version\cf2 >\cf0 \
	    \cf2 <\cf3 scope\cf2 >\cf0 test\cf2 </\cf3 scope\cf2 >\cf0 \
	\cf2 </\cf3 dependency\cf2 >
\f0\b \cf0 \
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0
\cf0 PS: 
\f1\b0 don\'92t forget the
\f0\b  
\f1\b0 log4j.properties file\
\

\f0\b\fs28 Supplying New Parameters
\fs24 \
Adding new files:
\f1\b0 \
In class main in App.java there is a string called filenames, add the name of the text file without the txt. Add the required file in the data folder PA2/data. \
Example: To add test.txt, add \'93test\'94 to string fileNames and test.txt to the data folder.\

\f0\b Changing parameter values\

\f1\b0 Number of clusters: Change the variable clusters in line 18 in App.java. The variable is in class main. Default value set to 3.\
Distance Metric: Change the variable choice in line 20 in App.java. The variable is in class main. Default value set to 1.  1-cosine similarity, 2 - euclidean metric\
Threshold frequency: default value set to number of documents.\
\
\pard\pardeftab720\partightenfactor0

\f3 \cf0 \
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f1 \cf0 \
\
}