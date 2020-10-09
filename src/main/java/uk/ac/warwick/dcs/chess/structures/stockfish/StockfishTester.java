/* Copyright 2018 David Cai Wang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.warwick.dcs.chess.structures.stockfish;

import uk.ac.warwick.dcs.chess.structures.stockfish.engine.enums.Option;
import uk.ac.warwick.dcs.chess.structures.stockfish.engine.enums.Query;
import uk.ac.warwick.dcs.chess.structures.stockfish.engine.enums.QueryType;
import uk.ac.warwick.dcs.chess.structures.stockfish.engine.enums.Variant;
import uk.ac.warwick.dcs.chess.structures.stockfish.exceptions.StockfishInitException;

public class StockfishTester {
    public static void main(String[] args) throws StockfishInitException {
        StockfishClient client = new StockfishClient.Builder()
                .setPath("src/main/java/uk/ac/warwick/dcs/chess/structures/stockfish/engines/")
                .setInstances(4)
                .setOption(Option.Threads, 4) // Number of threads that Stockfish will use
                .setOption(Option.Skill_Level, 20) // Stockfish skill level 0-20
                .setVariant(Variant.BMI2) // Stockfish Variant
                .build();

        System.out.println(client.getBestMove(new Query.Builder(QueryType.Best_Move)
        .setFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1").build()));
    }
}
