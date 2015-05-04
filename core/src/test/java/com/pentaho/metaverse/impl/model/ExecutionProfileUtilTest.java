/*
 * PENTAHO CORPORATION PROPRIETARY AND CONFIDENTIAL
 *
 * Copyright 2002 - 2015 Pentaho Corporation (Pentaho). All rights reserved.
 *
 * NOTICE: All information including source code contained herein is, and
 * remains the sole property of Pentaho and its licensors. The intellectual
 * and technical concepts contained herein are proprietary and confidential
 * to, and are trade secrets of Pentaho and may be covered by U.S. and foreign
 * patents, or patents in process, and are protected by trade secret and
 * copyright laws. The receipt or possession of this source code and/or related
 * information does not convey or imply any rights to reproduce, disclose or
 * distribute its contents, or to manufacture, use, or sell anything that it
 * may describe, in whole or in part. Any reproduction, modification, distribution,
 * or public display of this information without the express written authorization
 * from Pentaho is strictly prohibited and in violation of applicable laws and
 * international treaties. Access to the source code contained herein is strictly
 * prohibited to anyone except those individuals and entities who have executed
 * confidentiality and non-disclosure agreements or other agreements with Pentaho,
 * explicitly covering such access.
 *
 */

package com.pentaho.metaverse.impl.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pentaho.metaverse.api.model.IExecutionProfile;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ExecutionProfileUtilTest {
  IExecutionProfile executionProfile;

  @Before
  public void setUp() throws Exception {
    executionProfile = new ExecutionProfile();
  }

  @Test
  public void testConstructor() {
    new ExecutionProfileUtil();
  }

  @Test
  public void testOutputExecutionProfile() throws Exception {
    ExecutionProfileUtil.outputExecutionProfile( System.out, null );
    ExecutionProfileUtil.outputExecutionProfile( System.out, executionProfile );
  }

  @Test( expected = IOException.class )
  public void testOutputExecutionProfileWithException() throws IOException {
    PrintStream mockStream = mock( PrintStream.class );
    doThrow( JsonProcessingException.class ).when( mockStream ).println( Mockito.anyString() );
    ExecutionProfileUtil.outputExecutionProfile( mockStream, executionProfile );
  }
}