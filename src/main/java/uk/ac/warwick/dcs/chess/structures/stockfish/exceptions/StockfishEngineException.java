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
package uk.ac.warwick.dcs.chess.structures.stockfish.exceptions;

public class StockfishEngineException extends RuntimeException {
    public StockfishEngineException() {
        super();
    }

    public StockfishEngineException(String message) {
        super(message);
    }

    public StockfishEngineException(String message, Throwable cause) {
        super(message, cause);
    }

    public StockfishEngineException(Throwable cause) {
        super(cause);
    }
}
