package br.com.rappi.sp.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rappi.sp.service.RappiService;
 
@Component
public class TaskRappi implements Tasklet {
	
	@Autowired
	RappiService service;
 
	// EXECUTA A JOB
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception   {
        service.enviarProdutos();
        return null;
    }    
}