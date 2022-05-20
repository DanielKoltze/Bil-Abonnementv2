package com.example.bilabonnement.services;

import com.example.bilabonnement.models.CarMakeStatistic;
import com.example.bilabonnement.repositories.CarStatisticRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticService {

    private CarStatisticRepository carStatisticRepository;

    public StatisticService(CarStatisticRepository carStatisticRepository) {
        this.carStatisticRepository = carStatisticRepository;
    }

    public List<CarMakeStatistic> getCarMakeStatistics() {
        List<CarMakeStatistic> carMakeStatistics = carStatisticRepository.getCarMakes();





        return carMakeStatistics;

    }




}
