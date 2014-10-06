package com.tojaoomy.jupiter.service.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class LuceneTest {

	// 索引存储位置
	private static String indexDir = "E:/lucene";

	// Field Name
	private static String fieldName = "content";

	/**
	 * 
	 * @param analyzer
	 *            分词器
	 * @throws IOException
	 */
	public static void createIndex(Analyzer analyzer) throws IOException {
		String[] contents = { 
				"考进清华北大是许多人的梦想", 
				"清华是中国著名高等学府",
				"清华大学时世界上最美丽的大学之一"
		};
		
		Directory directory = FSDirectory.open(new File(indexDir));
		
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
		IndexWriter indexWriter = new IndexWriter(directory, config);
		for(String text : contents){
			Document document = new Document();
			document.add(new TextField(fieldName, text, Field.Store.YES));
			indexWriter.addDocument(document);
		}
		indexWriter.commit();
		indexWriter.close();directory.close();
	}
	
	public static void searchIndex(String sentence,Analyzer analyzer) throws Exception{
		Directory directory = FSDirectory.open(new File(indexDir));
//		IndexReader indexReader = IndexReader.open(directory);
		DirectoryReader directoryReader = DirectoryReader.open(directory);
		IndexSearcher indexSearcher = new IndexSearcher(directoryReader);
		QueryParser parser = new QueryParser(fieldName, analyzer);
		Query query = parser.parse(sentence);
		System.out.println("query sentence : " + query.toString());
		TopDocs docs = indexSearcher.search(query, 10);
		ScoreDoc[] scoreDoc = docs.scoreDocs;
		System.out.println("total search " + docs.totalHits + " match records");
		for(ScoreDoc sd : scoreDoc){
			Document doc = indexSearcher.doc(sd.doc);
			System.out.println(doc.get(fieldName) + " score : " + sd.score);
			System.out.println(indexSearcher.explain(query, sd.doc));
		}
		directoryReader.close();
		directory.close();
	}
	
	public static void main(String[] args) throws Exception {
//		Analyzer analyzer = new IKAnalyzer(true);
		Analyzer analyzer = new StandardAnalyzer();
//		Analyzer analyzer = new ChineseAnalyzer();
//		createIndex(analyzer);
		searchIndex("梦想上清华", analyzer);
		
	}
}
