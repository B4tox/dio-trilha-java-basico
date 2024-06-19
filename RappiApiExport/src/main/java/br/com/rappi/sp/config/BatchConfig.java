package br.com.rappi.sp.config;

import br.com.rappi.sp.tasks.TaskRappi;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {
     
    @Autowired
    JobBuilderFactory jobs;
 
    @Autowired
    StepBuilderFactory steps;
    
    @Autowired
    TaskRappi taskRappi;
     
    @Bean
    public Step stepOne(){
        return steps.get("stepOne")
                .tasklet(taskRappi)
                .build();
    }
     
    @Bean
    public Job rappiJob(){
        return jobs.get("rappiJob")
                .incrementer(new RunIdIncrementer())
                .start(stepOne())
                .build();
    }
    
}