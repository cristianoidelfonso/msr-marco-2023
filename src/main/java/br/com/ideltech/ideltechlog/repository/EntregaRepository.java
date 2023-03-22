package br.com.ideltech.ideltechlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ideltech.ideltechlog.entity.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
