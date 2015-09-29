/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.cloudml.zen.ml.util

import java.util.Random

trait DiscreteSampler[@specialized(Double, Int, Float, Long) T] {
  def length: Int
  def used: Int
  def norm: T
  def sampleRandom(gen: Random): Int
  def sampleFrom(base: T, gen: Random): Int
  def update(state: Int, value: T): Unit
  def deltaUpdate(state: Int, delta: T): Unit
  def resetDist(probs: Array[T], space: Array[Int], psize: Int): DiscreteSampler[T]
  def resetDist(distIter: Iterator[(Int, T)], psize: Int): DiscreteSampler[T]
}
