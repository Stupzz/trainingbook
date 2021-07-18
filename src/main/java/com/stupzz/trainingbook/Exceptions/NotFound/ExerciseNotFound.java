package com.stupzz.trainingbook.Exceptions.NotFound;

public class ExerciseNotFound extends NotFoundException{
    public ExerciseNotFound() {
        super();
    }

    @Override
    public void handleException() {
        super.handleException();
        msg = "Exercise not found";
    }

}
