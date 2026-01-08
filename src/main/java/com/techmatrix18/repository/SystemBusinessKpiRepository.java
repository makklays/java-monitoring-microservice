package com.techmatrix18.repository;

import com.techmatrix18.model.SystemBusinessKpi;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

/**
 * Repository for managing SystemBusinessKpi entities.
 *
 * save(S entity)	                            Mono<T>	Сохраняет объект (insert или update)
 * saveAll(Iterable<S> entities)	            Flux<S>	Сохраняет несколько объектов
 * saveAll(Publisher<S> entityStream)	        Flux<S>	Сохраняет поток объектов (reactive)
 * findById(ID id)	                            Mono<T>	Найти объект по id
 * existsById(ID id)	                        Mono<Boolean>	Проверить, существует ли объект по id
 * findAll()	                                Flux<T>	Найти все объекты
 * findAllById(Iterable<ID> ids)	            Flux<T>	Найти объекты по списку id
 * findAll(Sort sort)	                        Flux<T>	Найти все объекты с сортировкой
 * count()	                                    Mono<Long>	Количество объектов в репозитории
 * deleteById(ID id)	                        Mono<Void>	Удалить объект по id
 * delete(T entity)	                            Mono<Void>	Удалить объект
 * deleteAll(Iterable<? extends T> entities)	Mono<Void>	Удалить список объектов
 * deleteAll()	                                Mono<Void>	Удалить все объекты
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 07.01.2026
 */
@Repository
public interface SystemBusinessKpiRepository extends ReactiveCrudRepository<SystemBusinessKpi, Long> {

    // Найти все KPI за конкретную дату
    Flux<SystemBusinessKpi> findAllByDate(LocalDate date);

    // Найти KPI за диапазон дат
    Flux<SystemBusinessKpi> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    // Найти KPI по имени метрики
    Flux<SystemBusinessKpi> findAllByMetricName(String metricName);

    // Найти KPI по валюте
    Flux<SystemBusinessKpi> findAllByCurrencyCode(String currencyCode);

    // Комбинированный поиск: дата + имя метрики
    Flux<SystemBusinessKpi> findAllByDateAndMetricName(LocalDate date, String metricName);

    // Комбинированный поиск: дата + имя метрики + валюта
    Flux<SystemBusinessKpi> findAllByDateAndMetricNameAndCurrencyCode(
        LocalDate date,
        String metricName,
        String currencyCode
    );
}

