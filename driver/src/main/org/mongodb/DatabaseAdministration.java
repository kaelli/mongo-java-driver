/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mongodb;

import java.util.Set;

/**
 * The administrative commands that can be run against a selected database.  Application developers should not normally need to call these
 * methods.
 */
public interface DatabaseAdministration {
    /**
     * Drops this database.
     *
     * @see <a href="http://docs.mongodb.org/manual/reference/commands/#dropDatabase">Drop database</a>
     */
    void drop();

    /**
     * @return a Set of the names of all the collections in this database
     */
    Set<String> getCollectionNames();

    /**
     * Create a new collection with the given name.
     *
     * @param collectionName the name for the new collection to create
     * @see <a href="http://docs.mongodb.org/manual/reference/command/create/#dbcmd.create">Create Command</a>
     */
    void createCollection(String collectionName);

    /**
     * Create a new collection with the selected options
     *
     * @param createCollectionOptions various options for creating the collection
     * @see <a href="http://docs.mongodb.org/manual/reference/command/create/#dbcmd.create">Create Command</a>
     */
    void createCollection(CreateCollectionOptions createCollectionOptions);

    /**
     * Rename the collection with oldCollectionName to the newCollectionName.
     *
     * @param oldCollectionName the collection to rename
     * @param newCollectionName the name the collection will be renamed to
     * @throws MongoServerException with code 10027 if you provide a newCollectionName that is the name of an existing collection, with code
     *                              10026 if the oldCollectionName is the name of a collection that doesn't exist
     * @see <a href="http://docs.mongodb.org/manual/reference/command/renameCollection/">Rename collection</a>
     */
    void renameCollection(String oldCollectionName, String newCollectionName);

    /**
     * Rename the collection with oldCollectionName to the newCollectionName.
     *
     * @param oldCollectionName the collection to rename
     * @param newCollectionName the name the collection will be renamed to
     * @param dropTarget        setting this to true will drop any existing database with the name newCollectionName
     * @throws MongoServerException with code 10027 if you provide a newCollectionName that is the name of an existing collection and
     *                              dropTarget is false, with code 10026 if the oldCollectionName is the name of a collection that doesn't
     *                              exist
     * @see <a href="http://docs.mongodb.org/manual/reference/command/renameCollection/">Rename collection</a>
     */
    void renameCollection(String oldCollectionName, String newCollectionName, boolean dropTarget);
}