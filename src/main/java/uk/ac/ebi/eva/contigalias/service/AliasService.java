/*
 * Copyright 2020 EMBL - European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.ebi.eva.contigalias.service;

import org.springframework.beans.factory.annotation.Autowired;

import uk.ac.ebi.eva.contigalias.entities.AssemblyEntity;
import uk.ac.ebi.eva.contigalias.entities.ChromosomeEntity;

import java.util.Optional;

public class AliasService {

    private final AssemblyService assemblyService;

    private final ChromosomeService chromosomeService;

    @Autowired
    public AliasService(AssemblyService assemblyService,
                        ChromosomeService chromosomeService) {
        this.assemblyService = assemblyService;
        this.chromosomeService = chromosomeService;
    }

    public Optional<AssemblyEntity> getAssemblyByChromosomeGenbank(String chrGenbank) {
        Optional<ChromosomeEntity> chromosomeByGenbank = chromosomeService.getChromosomeByGenbank(chrGenbank);
        return chromosomeByGenbank.map(ChromosomeEntity::getAssembly);
    }

    public Optional<AssemblyEntity> getAssemblyByChromosomeRefseq(String chrRefseq) {
        Optional<ChromosomeEntity> chromosomeByGenbank = chromosomeService.getChromosomeByRefseq(chrRefseq);
        return chromosomeByGenbank.map(ChromosomeEntity::getAssembly);
    }

}
