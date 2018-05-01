package demo;

import blang.core.ConstantSupplier;
import blang.core.DeboxedName;
import blang.core.IntVar;
import blang.core.Model;
import blang.core.ModelBuilder;
import blang.core.ModelComponent;
import blang.core.Param;
import blang.core.RealVar;
import blang.inits.Arg;
import blang.inits.DesignatedConstructor;
import blang.types.DenseSimplex;
import blang.types.Simplex;
import blang.types.StaticUtils;
import ca.ubc.stat.blang.StaticJavaUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

@SuppressWarnings("all")
public class Mixture implements Model {
  public static class Builder implements ModelBuilder {
    private boolean fromCommandLine = false;
    
    @Arg
    public Optional<Integer> K;
    
    public Mixture.Builder setK(final Integer K) {
      // work around typeRef(..) limitation
      Optional<Integer> $generated__dummy = null;
      this.K = Optional.of(K);
      return this;
    }
    
    @Arg
    public List<RealVar> data;
    
    private boolean data_initialized = false;
    
    public Mixture.Builder setData(final List<RealVar> data) {
      data_initialized = true;
      this.data = data;
      return this;
    }
    
    @Arg
    public Optional<Simplex> pi;
    
    public Mixture.Builder setPi(final Simplex pi) {
      // work around typeRef(..) limitation
      Optional<Simplex> $generated__dummy = null;
      this.pi = Optional.of(pi);
      return this;
    }
    
    @Arg
    public Optional<List<IntVar>> indicators;
    
    public Mixture.Builder setIndicators(final List<IntVar> indicators) {
      // work around typeRef(..) limitation
      Optional<List<IntVar>> $generated__dummy = null;
      this.indicators = Optional.of(indicators);
      return this;
    }
    
    @Arg
    public Optional<List<RealVar>> means;
    
    public Mixture.Builder setMeans(final List<RealVar> means) {
      // work around typeRef(..) limitation
      Optional<List<RealVar>> $generated__dummy = null;
      this.means = Optional.of(means);
      return this;
    }
    
    @Arg
    public Optional<List<RealVar>> sds;
    
    public Mixture.Builder setSds(final List<RealVar> sds) {
      // work around typeRef(..) limitation
      Optional<List<RealVar>> $generated__dummy = null;
      this.sds = Optional.of(sds);
      return this;
    }
    
    public Mixture build() {
      // For each optional type, either get the value, or evaluate the ?: expression
      Integer K;
      if (this.K != null && this.K.isPresent()) {
        K = this.K.get();
      } else {
        K = $generated__16();
      }
      final Integer __K = K;
      if (!fromCommandLine && !data_initialized)
        throw new RuntimeException("Not all fields were set in the builder, e.g. missing data");
      final List<RealVar> __data = data;
      Simplex pi;
      if (this.pi != null && this.pi.isPresent()) {
        pi = this.pi.get();
      } else {
        pi = $generated__17(K, data);
      }
      final Simplex __pi = pi;
      List<IntVar> indicators;
      if (this.indicators != null && this.indicators.isPresent()) {
        indicators = this.indicators.get();
      } else {
        indicators = $generated__18(K, data, pi);
      }
      final List<IntVar> __indicators = indicators;
      List<RealVar> means;
      if (this.means != null && this.means.isPresent()) {
        means = this.means.get();
      } else {
        means = $generated__19(K, data, pi, indicators);
      }
      final List<RealVar> __means = means;
      List<RealVar> sds;
      if (this.sds != null && this.sds.isPresent()) {
        sds = this.sds.get();
      } else {
        sds = $generated__20(K, data, pi, indicators, means);
      }
      final List<RealVar> __sds = sds;
      // Build the instance after boxing params
      return new Mixture(
        __data, 
        __pi, 
        __indicators, 
        __means, 
        __sds, 
        new ConstantSupplier(__K)
      );
    }
  }
  
  @DesignatedConstructor
  public static Mixture.Builder builderFromCommandLine() {
    Builder result = new Builder();
    result.fromCommandLine = true;
    return result;
  }
  
  @Param
  private final Supplier<Integer> $generated__K;
  
  public Integer getK() {
    return $generated__K.get();
  }
  
  private final List<RealVar> data;
  
  public List<RealVar> getData() {
    return data;
  }
  
  private final Simplex pi;
  
  public Simplex getPi() {
    return pi;
  }
  
  private final List<IntVar> indicators;
  
  public List<IntVar> getIndicators() {
    return indicators;
  }
  
  private final List<RealVar> means;
  
  public List<RealVar> getMeans() {
    return means;
  }
  
  private final List<RealVar> sds;
  
  public List<RealVar> getSds() {
    return sds;
  }
  
  /**
   * Utility main method for posterior inference on this model
   */
  public static void main(final String[] arguments) {
    StaticJavaUtils.callRunner(Builder.class, arguments);
  }
  
  /**
   * Auxiliary method generated to translate:
   * pi
   */
  private static Simplex $generated__0(final Integer K, final List<RealVar> data, final Simplex pi, final List<IntVar> indicators, final List<RealVar> means, final List<RealVar> sds) {
    return pi;
  }
  
  /**
   * Auxiliary method generated to translate:
   * K
   */
  private static Integer $generated__1(final Integer K) {
    return K;
  }
  
  public static class $generated__1_class implements Supplier<Integer> {
    public Integer get() {
      return $generated__1($generated__K.get());
    }
    
    public String toString() {
      return "K";
    }
    
    private final Supplier<Integer> $generated__K;
    
    public $generated__1_class(final Supplier<Integer> $generated__K) {
      this.$generated__K = $generated__K;
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * 0 ..< K
   */
  private static Iterable<Integer> $generated__2(final Integer K, final List<RealVar> data, final Simplex pi, final List<IntVar> indicators, final List<RealVar> means, final List<RealVar> sds) {
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, (K).intValue(), true);
    return _doubleDotLessThan;
  }
  
  /**
   * Auxiliary method generated to translate:
   * means.get(k)
   */
  private static RealVar $generated__3(final int k, final Integer K, final List<RealVar> data, final Simplex pi, final List<IntVar> indicators, final List<RealVar> means, final List<RealVar> sds) {
    RealVar _get = means.get(k);
    return _get;
  }
  
  /**
   * Auxiliary method generated to translate:
   * 150.0
   */
  private static RealVar $generated__4() {
    return new blang.core.RealConstant(150.0);
  }
  
  public static class $generated__4_class implements Supplier<RealVar> {
    public RealVar get() {
      return $generated__4();
    }
    
    public String toString() {
      return "150.0";
    }
    
    public $generated__4_class() {
      
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * pow(100, 2.0)
   */
  private static RealVar $generated__5() {
    double _pow = Math.pow(100, 2.0);
    return new blang.core.RealConstant(_pow);
  }
  
  public static class $generated__5_class implements Supplier<RealVar> {
    public RealVar get() {
      return $generated__5();
    }
    
    public String toString() {
      return "pow(100, 2.0)";
    }
    
    public $generated__5_class() {
      
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * sds.get(k)
   */
  private static RealVar $generated__6(final int k, final Integer K, final List<RealVar> data, final Simplex pi, final List<IntVar> indicators, final List<RealVar> means, final List<RealVar> sds) {
    RealVar _get = sds.get(k);
    return _get;
  }
  
  /**
   * Auxiliary method generated to translate:
   * 0.0
   */
  private static RealVar $generated__7() {
    return new blang.core.RealConstant(0.0);
  }
  
  public static class $generated__7_class implements Supplier<RealVar> {
    public RealVar get() {
      return $generated__7();
    }
    
    public String toString() {
      return "0.0";
    }
    
    public $generated__7_class() {
      
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * 100.0
   */
  private static RealVar $generated__8() {
    return new blang.core.RealConstant(100.0);
  }
  
  public static class $generated__8_class implements Supplier<RealVar> {
    public RealVar get() {
      return $generated__8();
    }
    
    public String toString() {
      return "100.0";
    }
    
    public $generated__8_class() {
      
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * 0 ..< data.size
   */
  private static Iterable<Integer> $generated__9(final Integer K, final List<RealVar> data, final Simplex pi, final List<IntVar> indicators, final List<RealVar> means, final List<RealVar> sds) {
    int _size = data.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    return _doubleDotLessThan;
  }
  
  /**
   * Auxiliary method generated to translate:
   * indicators.get(n)
   */
  private static IntVar $generated__10(final int n, final Integer K, final List<RealVar> data, final Simplex pi, final List<IntVar> indicators, final List<RealVar> means, final List<RealVar> sds) {
    IntVar _get = indicators.get(n);
    return _get;
  }
  
  /**
   * Auxiliary method generated to translate:
   * pi
   */
  private static Simplex $generated__11(final Simplex pi) {
    return pi;
  }
  
  public static class $generated__11_class implements Supplier<Simplex> {
    public Simplex get() {
      return $generated__11(pi);
    }
    
    public String toString() {
      return "pi";
    }
    
    private final Simplex pi;
    
    public $generated__11_class(final Simplex pi) {
      this.pi = pi;
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * indicators.get(n)
   */
  private static IntVar $generated__12(final int n, final Integer K, final List<RealVar> data, final Simplex pi, final List<IntVar> indicators, final List<RealVar> means, final List<RealVar> sds) {
    IntVar _get = indicators.get(n);
    return _get;
  }
  
  /**
   * Auxiliary method generated to translate:
   * data.get(n)
   */
  private static RealVar $generated__13(final int n, final Integer K, final List<RealVar> data, final Simplex pi, final List<IntVar> indicators, final List<RealVar> means, final List<RealVar> sds) {
    RealVar _get = data.get(n);
    return _get;
  }
  
  /**
   * Auxiliary method generated to translate:
   * means.get(indic)
   */
  private static RealVar $generated__14(final IntVar indic, final List<RealVar> means, final List<RealVar> sds) {
    RealVar _get = means.get((indic).intValue());
    return _get;
  }
  
  public static class $generated__14_class implements Supplier<RealVar> {
    public RealVar get() {
      return $generated__14(indic, means, sds);
    }
    
    public String toString() {
      return "means.get(indic)";
    }
    
    private final IntVar indic;
    
    private final List<RealVar> means;
    
    private final List<RealVar> sds;
    
    public $generated__14_class(final IntVar indic, final List<RealVar> means, final List<RealVar> sds) {
      this.indic = indic;
      this.means = means;
      this.sds = sds;
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * pow(sds.get(indic), 2.0)
   */
  private static RealVar $generated__15(final IntVar indic, final List<RealVar> means, final List<RealVar> sds) {
    double _pow = Math.pow((sds.get((indic).intValue())).doubleValue(), 2.0);
    return new blang.core.RealConstant(_pow);
  }
  
  public static class $generated__15_class implements Supplier<RealVar> {
    public RealVar get() {
      return $generated__15(indic, means, sds);
    }
    
    public String toString() {
      return "pow(sds.get(indic), 2.0)";
    }
    
    private final IntVar indic;
    
    private final List<RealVar> means;
    
    private final List<RealVar> sds;
    
    public $generated__15_class(final IntVar indic, final List<RealVar> means, final List<RealVar> sds) {
      this.indic = indic;
      this.means = means;
      this.sds = sds;
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * 2
   */
  private static Integer $generated__16() {
    return Integer.valueOf(2);
  }
  
  /**
   * Auxiliary method generated to translate:
   * latentSimplex(K)
   */
  private static Simplex $generated__17(final Integer K, final List<RealVar> data) {
    DenseSimplex _latentSimplex = StaticUtils.latentSimplex((K).intValue());
    return _latentSimplex;
  }
  
  /**
   * Auxiliary method generated to translate:
   * latentIntList(data.size)
   */
  private static List<IntVar> $generated__18(final Integer K, final List<RealVar> data, final Simplex pi) {
    List<IntVar> _latentIntList = StaticUtils.latentIntList(data.size());
    return _latentIntList;
  }
  
  /**
   * Auxiliary method generated to translate:
   * latentRealList(K)
   */
  private static List<RealVar> $generated__19(final Integer K, final List<RealVar> data, final Simplex pi, final List<IntVar> indicators) {
    List<RealVar> _latentRealList = StaticUtils.latentRealList((K).intValue());
    return _latentRealList;
  }
  
  /**
   * Auxiliary method generated to translate:
   * latentRealList(K)
   */
  private static List<RealVar> $generated__20(final Integer K, final List<RealVar> data, final Simplex pi, final List<IntVar> indicators, final List<RealVar> means) {
    List<RealVar> _latentRealList = StaticUtils.latentRealList((K).intValue());
    return _latentRealList;
  }
  
  /**
   * Note: the generated code has the following properties used at runtime:
   *   - all arguments are annotated with a BlangVariable annotation
   *   - params additionally have a Param annotation
   *   - the order of the arguments is as follows:
   *     - first, all the random variables in the order they occur in the blang file
   *     - second, all the params in the order they occur in the blang file
   * 
   */
  public Mixture(@DeboxedName("data") final List<RealVar> data, @DeboxedName("pi") final Simplex pi, @DeboxedName("indicators") final List<IntVar> indicators, @DeboxedName("means") final List<RealVar> means, @DeboxedName("sds") final List<RealVar> sds, @Param @DeboxedName("K") final Supplier<Integer> $generated__K) {
    this.$generated__K = $generated__K;
    this.data = data;
    this.pi = pi;
    this.indicators = indicators;
    this.means = means;
    this.sds = sds;
  }
  
  /**
   * A component can be either a distribution, support constraint, or another model  
   * which recursively defines additional components.
   */
  public Collection<ModelComponent> components() {
    ArrayList<ModelComponent> components = new ArrayList();
    
    { // Code generated by: pi | K ~ SimplexUniform(K)
      // Construction and addition of the factor/model:
      components.add(
        new blang.distributions.SimplexUniform(
          $generated__0($generated__K.get(), data, pi, indicators, means, sds), 
          new $generated__1_class($generated__K)
        )
        );
    }
    for (int k : $generated__2($generated__K.get(), data, pi, indicators, means, sds)) {
      { // Code generated by: means.get(k) ~ Normal(150.0, pow(100, 2.0))
        // Construction and addition of the factor/model:
        components.add(
          new blang.distributions.Normal(
            $generated__3(k, $generated__K.get(), data, pi, indicators, means, sds), 
            new $generated__4_class(), 
            new $generated__5_class()
          )
          );
      }
      { // Code generated by: sds.get(k) ~ ContinuousUniform(0.0, 100.0)
        // Construction and addition of the factor/model:
        components.add(
          new blang.distributions.ContinuousUniform(
            $generated__6(k, $generated__K.get(), data, pi, indicators, means, sds), 
            new $generated__7_class(), 
            new $generated__8_class()
          )
          );
      }
    }
    for (int n : $generated__9($generated__K.get(), data, pi, indicators, means, sds)) {
      { // Code generated by: indicators.get(n) | pi ~ Categorical(pi)
        // Construction and addition of the factor/model:
        components.add(
          new blang.distributions.Categorical(
            $generated__10(n, $generated__K.get(), data, pi, indicators, means, sds), 
            new $generated__11_class(pi)
          )
          );
      }
      { // Code generated by: data.get(n) | IntVar indic = indicators.get(n), means, sds ~ Normal(means.get(indic), pow(sds.get(indic), 2.0))
        // Required initialization:
        IntVar indic = $generated__12(n, $generated__K.get(), data, pi, indicators, means, sds);
        // Construction and addition of the factor/model:
        components.add(
          new blang.distributions.Normal(
            $generated__13(n, $generated__K.get(), data, pi, indicators, means, sds), 
            new $generated__14_class(indic, means, sds), 
            new $generated__15_class(indic, means, sds)
          )
          );
      }
    }
    
    return components;
  }
}
