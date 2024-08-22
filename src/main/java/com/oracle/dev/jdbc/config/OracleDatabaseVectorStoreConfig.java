package com.oracle.dev.jdbc.config;

import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.oracle.dev.jdbc.utils.OracleDistanceType;
import com.oracle.dev.jdbc.vectorstore.OracleDatabaseVectorStore;

@Configuration
public class OracleDatabaseVectorStoreConfig {

  @Bean
  public VectorStore vectorStore(JdbcTemplate jdbcTemplate,
      EmbeddingClient embeddingClient) {
    return new OracleDatabaseVectorStore(jdbcTemplate, embeddingClient,
        OracleDistanceType.COSINE);
  }

}
