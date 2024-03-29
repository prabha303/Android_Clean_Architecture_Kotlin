/**
 * Copyright (C) 2018 Fernando Cejas Open Source Project
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
package com.prabha.cleanarchitecture.features.movies

import android.content.Context
import com.prabha.cleanarchitecture.features.movies.PlayMovie.Params
import com.prabha.cleanarchitecture.core.exception.Failure
import com.prabha.cleanarchitecture.core.functional.Either
import com.prabha.cleanarchitecture.core.functional.Either.Right
import com.prabha.cleanarchitecture.core.interactor.UseCase
import com.prabha.cleanarchitecture.core.interactor.UseCase.None
import com.prabha.cleanarchitecture.core.navigation.Navigator
import javax.inject.Inject

class PlayMovie
@Inject constructor(private val context: Context,
                    private val navigator: Navigator) : UseCase<None, Params>() {

    override suspend fun run(params: Params): Either<Failure, None> {
        navigator.openVideo(context, params.url)
        return Right(None())
    }

    data class Params(val url: String)
}
