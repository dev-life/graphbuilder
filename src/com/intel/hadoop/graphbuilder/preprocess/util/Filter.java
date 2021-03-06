/* Copyright (C) 2012 Intel Corporation.
 *     All rights reserved.
 *           
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * For more about this software visit:
 *      http://www.01.org/GraphBuilder 
 */
package com.intel.hadoop.graphbuilder.preprocess.util;

/**
 * A String filter is lambda funtion f: string -> string. Filters can be
 * appended, or composed through the {@code append} function.
 * 
 */
public abstract class Filter {
  abstract String process(String s);

  Filter append(final Filter f) {
    return new Filter() {
      @Override
      String process(String s) {
        return process(f.process(s));
      }
    };
  }
}
