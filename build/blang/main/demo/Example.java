package demo;

import blang.core.ConstantSupplier;
import blang.core.DeboxedName;
import blang.core.Model;
import blang.core.ModelBuilder;
import blang.core.ModelComponent;
import blang.core.Param;
import blang.core.RealDistribution;
import blang.core.RealVar;
import blang.distributions.Gamma;
import blang.inits.Arg;
import blang.inits.DesignatedConstructor;
import blang.types.StaticUtils;
import blang.types.internals.RealScalar;
import ca.ubc.stat.blang.StaticJavaUtils;
import conifer.EvolutionaryModel;
import conifer.SequenceAlignment;
import conifer.UnrootedTree;
import conifer.Utils;
import conifer.io.TreeObservations;
import conifer.models.MultiCategorySubstitutionModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

@SuppressWarnings("all")
public class Example implements Model {
  public static class Builder implements ModelBuilder {
    private boolean fromCommandLine = false;
    
    @Arg
    public Optional<RealVar> shape;
    
    public Example.Builder setShape(final RealVar shape) {
      // work around typeRef(..) limitation
      Optional<RealVar> $generated__dummy = null;
      this.shape = Optional.of(shape);
      return this;
    }
    
    @Arg
    public Optional<RealVar> rate;
    
    public Example.Builder setRate(final RealVar rate) {
      // work around typeRef(..) limitation
      Optional<RealVar> $generated__dummy = null;
      this.rate = Optional.of(rate);
      return this;
    }
    
    @Arg
    public SequenceAlignment observations;
    
    private boolean observations_initialized = false;
    
    public Example.Builder setObservations(final SequenceAlignment observations) {
      observations_initialized = true;
      this.observations = observations;
      return this;
    }
    
    @Arg
    public Optional<UnrootedTree> tree;
    
    public Example.Builder setTree(final UnrootedTree tree) {
      // work around typeRef(..) limitation
      Optional<UnrootedTree> $generated__dummy = null;
      this.tree = Optional.of(tree);
      return this;
    }
    
    @Arg
    public Optional<EvolutionaryModel> evoModel;
    
    public Example.Builder setEvoModel(final EvolutionaryModel evoModel) {
      // work around typeRef(..) limitation
      Optional<EvolutionaryModel> $generated__dummy = null;
      this.evoModel = Optional.of(evoModel);
      return this;
    }
    
    public Example build() {
      // For each optional type, either get the value, or evaluate the ?: expression
      RealVar shape;
      if (this.shape != null && this.shape.isPresent()) {
        shape = this.shape.get();
      } else {
        shape = $generated__9();
      }
      final RealVar __shape = shape;
      RealVar rate;
      if (this.rate != null && this.rate.isPresent()) {
        rate = this.rate.get();
      } else {
        rate = $generated__10(shape);
      }
      final RealVar __rate = rate;
      if (!fromCommandLine && !observations_initialized)
        throw new RuntimeException("Not all fields were set in the builder, e.g. missing observations");
      final SequenceAlignment __observations = observations;
      UnrootedTree tree;
      if (this.tree != null && this.tree.isPresent()) {
        tree = this.tree.get();
      } else {
        tree = $generated__11(shape, rate, observations);
      }
      final UnrootedTree __tree = tree;
      EvolutionaryModel evoModel;
      if (this.evoModel != null && this.evoModel.isPresent()) {
        evoModel = this.evoModel.get();
      } else {
        evoModel = $generated__12(shape, rate, observations, tree);
      }
      final EvolutionaryModel __evoModel = evoModel;
      // Build the instance after boxing params
      return new Example(
        __shape, 
        __rate, 
        __observations, 
        __tree, 
        new ConstantSupplier(__evoModel)
      );
    }
  }
  
  @DesignatedConstructor
  public static Example.Builder builderFromCommandLine() {
    Builder result = new Builder();
    result.fromCommandLine = true;
    return result;
  }
  
  private final RealVar shape;
  
  public RealVar getShape() {
    return shape;
  }
  
  private final RealVar rate;
  
  public RealVar getRate() {
    return rate;
  }
  
  private final SequenceAlignment observations;
  
  public SequenceAlignment getObservations() {
    return observations;
  }
  
  private final UnrootedTree tree;
  
  public UnrootedTree getTree() {
    return tree;
  }
  
  @Param
  private final Supplier<EvolutionaryModel> $generated__evoModel;
  
  public EvolutionaryModel getEvoModel() {
    return $generated__evoModel.get();
  }
  
  /**
   * Utility main method for posterior inference on this model
   */
  public static void main(final String[] arguments) {
    StaticJavaUtils.callRunner(Builder.class, arguments);
  }
  
  /**
   * Auxiliary method generated to translate:
   * shape
   */
  private static RealVar $generated__0(final RealVar shape, final RealVar rate, final SequenceAlignment observations, final UnrootedTree tree, final EvolutionaryModel evoModel) {
    return shape;
  }
  
  /**
   * Auxiliary method generated to translate:
   * 1.0
   */
  private static RealVar $generated__1() {
    return new blang.core.RealConstant(1.0);
  }
  
  public static class $generated__1_class implements Supplier<RealVar> {
    public RealVar get() {
      return $generated__1();
    }
    
    public String toString() {
      return "1.0";
    }
    
    public $generated__1_class() {
      
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * rate
   */
  private static RealVar $generated__2(final RealVar shape, final RealVar rate, final SequenceAlignment observations, final UnrootedTree tree, final EvolutionaryModel evoModel) {
    return rate;
  }
  
  /**
   * Auxiliary method generated to translate:
   * 1.0
   */
  private static RealVar $generated__3() {
    return new blang.core.RealConstant(1.0);
  }
  
  public static class $generated__3_class implements Supplier<RealVar> {
    public RealVar get() {
      return $generated__3();
    }
    
    public String toString() {
      return "1.0";
    }
    
    public $generated__3_class() {
      
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * tree
   */
  private static UnrootedTree $generated__4(final RealVar shape, final RealVar rate, final SequenceAlignment observations, final UnrootedTree tree, final EvolutionaryModel evoModel) {
    return tree;
  }
  
  /**
   * Auxiliary method generated to translate:
   * Gamma::distribution(shape, rate)
   */
  private static RealDistribution $generated__5(final RealVar shape, final RealVar rate) {
    RealDistribution _distribution = Gamma.distribution(shape, rate);
    return _distribution;
  }
  
  public static class $generated__5_class implements Supplier<RealDistribution> {
    public RealDistribution get() {
      return $generated__5(shape, rate);
    }
    
    public String toString() {
      return "Gamma::distribution(shape, rate)";
    }
    
    private final RealVar shape;
    
    private final RealVar rate;
    
    public $generated__5_class(final RealVar shape, final RealVar rate) {
      this.shape = shape;
      this.rate = rate;
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * observations
   */
  private static TreeObservations $generated__6(final RealVar shape, final RealVar rate, final SequenceAlignment observations, final UnrootedTree tree, final EvolutionaryModel evoModel) {
    return observations;
  }
  
  /**
   * Auxiliary method generated to translate:
   * tree
   */
  private static UnrootedTree $generated__7(final UnrootedTree tree, final EvolutionaryModel evoModel) {
    return tree;
  }
  
  public static class $generated__7_class implements Supplier<UnrootedTree> {
    public UnrootedTree get() {
      return $generated__7(tree, $generated__evoModel.get());
    }
    
    public String toString() {
      return "tree";
    }
    
    private final UnrootedTree tree;
    
    private final Supplier<EvolutionaryModel> $generated__evoModel;
    
    public $generated__7_class(final UnrootedTree tree, final Supplier<EvolutionaryModel> $generated__evoModel) {
      this.tree = tree;
      this.$generated__evoModel = $generated__evoModel;
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * evoModel
   */
  private static EvolutionaryModel $generated__8(final UnrootedTree tree, final EvolutionaryModel evoModel) {
    return evoModel;
  }
  
  public static class $generated__8_class implements Supplier<EvolutionaryModel> {
    public EvolutionaryModel get() {
      return $generated__8(tree, $generated__evoModel.get());
    }
    
    public String toString() {
      return "evoModel";
    }
    
    private final UnrootedTree tree;
    
    private final Supplier<EvolutionaryModel> $generated__evoModel;
    
    public $generated__8_class(final UnrootedTree tree, final Supplier<EvolutionaryModel> $generated__evoModel) {
      this.tree = tree;
      this.$generated__evoModel = $generated__evoModel;
    }
  }
  
  /**
   * Auxiliary method generated to translate:
   * latentReal
   */
  private static RealVar $generated__9() {
    RealScalar _latentReal = StaticUtils.latentReal();
    return _latentReal;
  }
  
  /**
   * Auxiliary method generated to translate:
   * latentReal
   */
  private static RealVar $generated__10(final RealVar shape) {
    RealScalar _latentReal = StaticUtils.latentReal();
    return _latentReal;
  }
  
  /**
   * Auxiliary method generated to translate:
   * unrootedTree(observations.observedTreeNodes)
   */
  private static UnrootedTree $generated__11(final RealVar shape, final RealVar rate, final SequenceAlignment observations) {
    UnrootedTree _unrootedTree = Utils.unrootedTree(observations.getObservedTreeNodes());
    return _unrootedTree;
  }
  
  /**
   * Auxiliary method generated to translate:
   * kimura(observations.nSites)
   */
  private static EvolutionaryModel $generated__12(final RealVar shape, final RealVar rate, final SequenceAlignment observations, final UnrootedTree tree) {
    MultiCategorySubstitutionModel _kimura = Utils.kimura(observations.nSites());
    return _kimura;
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
  public Example(@DeboxedName("shape") final RealVar shape, @DeboxedName("rate") final RealVar rate, @DeboxedName("observations") final SequenceAlignment observations, @DeboxedName("tree") final UnrootedTree tree, @Param @DeboxedName("evoModel") final Supplier<EvolutionaryModel> $generated__evoModel) {
    this.shape = shape;
    this.rate = rate;
    this.observations = observations;
    this.tree = tree;
    this.$generated__evoModel = $generated__evoModel;
  }
  
  /**
   * A component can be either a distribution, support constraint, or another model  
   * which recursively defines additional components.
   */
  public Collection<ModelComponent> components() {
    ArrayList<ModelComponent> components = new ArrayList();
    
    { // Code generated by: shape ~ Exponential(1.0)
      // Construction and addition of the factor/model:
      components.add(
        new blang.distributions.Exponential(
          $generated__0(shape, rate, observations, tree, $generated__evoModel.get()), 
          new $generated__1_class()
        )
        );
    }
    { // Code generated by: rate ~ Exponential(1.0)
      // Construction and addition of the factor/model:
      components.add(
        new blang.distributions.Exponential(
          $generated__2(shape, rate, observations, tree, $generated__evoModel.get()), 
          new $generated__3_class()
        )
        );
    }
    { // Code generated by: tree | shape, rate ~ NonClockTreePrior(Gamma::distribution(shape, rate))
      // Construction and addition of the factor/model:
      components.add(
        new conifer.NonClockTreePrior(
          $generated__4(shape, rate, observations, tree, $generated__evoModel.get()), 
          new $generated__5_class(shape, rate)
        )
        );
    }
    { // Code generated by: observations | tree, evoModel ~ UnrootedTreeLikelihood(tree, evoModel)
      // Construction and addition of the factor/model:
      components.add(
        new conifer.UnrootedTreeLikelihood(
          $generated__6(shape, rate, observations, tree, $generated__evoModel.get()), 
          new $generated__7_class(tree, $generated__evoModel), 
          new $generated__8_class(tree, $generated__evoModel)
        )
        );
    }
    
    return components;
  }
}
