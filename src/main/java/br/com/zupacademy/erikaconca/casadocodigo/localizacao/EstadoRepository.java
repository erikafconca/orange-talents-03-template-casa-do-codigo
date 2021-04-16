package br.com.zupacademy.erikaconca.casadocodigo.localizacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    boolean existsByNomeAndPais_Id(String nome, Long id);

    boolean existsByNomeAndPais(String nome, Pais pais);

    boolean existsByPaisId(Long id);

    boolean existsByIdAndPais_Id(Long idEstado, Long IdPais);

}
